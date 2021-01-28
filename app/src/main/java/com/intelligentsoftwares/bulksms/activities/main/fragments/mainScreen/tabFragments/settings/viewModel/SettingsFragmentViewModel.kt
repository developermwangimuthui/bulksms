package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.settings.viewModel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.intelligentsoftwares.bulksms.backend.MyCustomApplication
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsDao
import com.intelligentsoftwares.bulksms.util.Constants
import com.intelligentsoftwares.bulksms.util.Event
import com.intelligentsoftwares.bulksms.util.subscriptionManager

/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */
@SuppressLint("MissingPermission")
class SettingsFragmentViewModel(
    application: MyCustomApplication,
    private val bulkSmsDao: BulkSmsDao
) : AndroidViewModel(application) {

    private val _uiState = MutableLiveData<SettingsUiModel>()
    private val coroutineContext = Dispatchers.Default + SupervisorJob()

    val uiState: LiveData<SettingsUiModel> get() = _uiState

    fun deleteAllBulkSms() {
        viewModelScope.launch(coroutineContext) {
            bulkSmsDao.nukeSmsTable()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun handleDeviceCarrierNumbers() {
        val subscriptionManager = getApplication<MyCustomApplication>().subscriptionManager
        val allCarrierNumbers = subscriptionManager.activeSubscriptionInfoList.map {
            it.subscriptionId.toString()
                .plus("${Constants.CARRIER_NAME_SPLITTER} ${it.carrierName}(${it.number})")
        }
        viewModelScope.launch(coroutineContext) {
            when {
                allCarrierNumbers.isEmpty() -> emitUiState(noDeviceNumber = true)
                else -> emitUiState(
                    showMultipleCarrierNumber = Event(allCarrierNumbers)
                )
            }
        }
    }

    private suspend fun emitUiState(
        noDeviceNumber: Boolean = false, showMultipleCarrierNumber: Event<List<String>>? = null
    ) = withContext(Dispatchers.Main) {
        SettingsUiModel(noDeviceNumber, showMultipleCarrierNumber).also {
            _uiState.value = it
        }
    }
}

data class SettingsUiModel(
    val noDeviceNumber: Boolean,
    val showMultipleCarrierNumber: Event<List<String>>?
)