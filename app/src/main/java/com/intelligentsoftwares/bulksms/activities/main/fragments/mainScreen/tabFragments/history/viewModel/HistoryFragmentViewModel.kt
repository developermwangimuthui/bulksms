package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.history.viewModel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import com.intelligentsoftwares.bulksms.backend.MyCustomApplication
import com.intelligentsoftwares.bulksms.helper.SharedPreferenceHelper
import com.intelligentsoftwares.bulksms.helper.SharedPreferenceHelper.Companion.BULKS_SMS_PREVIOUS_WORKER_ID
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSms
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsDao
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsStatus
import com.intelligentsoftwares.bulksms.util.cancelWorker
import com.intelligentsoftwares.bulksms.util.notificationManager

/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 6/28/19}
 */

class HistoryFragmentViewModel constructor(
    application: MyCustomApplication,
    private val bulkSmsDao: BulkSmsDao,
    private val sharedPreferenceHelper: SharedPreferenceHelper
) : AndroidViewModel(application) {

    private val coroutineContext = Dispatchers.Default + SupervisorJob()

    val allTasks: LiveData<List<BulkSms>> = bulkSmsDao.all()

    fun deleteBulkSms(bulkSms: BulkSms) {
        viewModelScope.launch(coroutineContext) {
            bulkSmsDao.delete(bulkSms)
        }
    }

    fun cancelBulkSmsOperation(bulkSms: BulkSms) {
        viewModelScope.launch {
            val previousWorkerId = sharedPreferenceHelper.getString(BULKS_SMS_PREVIOUS_WORKER_ID)
            previousWorkerId?.let {
                val application = getApplication<MyCustomApplication>()
                application.cancelWorker(it)
                bulkSmsDao.update(System.currentTimeMillis(), BulkSmsStatus.CANCELLED, bulkSms.id)
                sharedPreferenceHelper.put(BULKS_SMS_PREVIOUS_WORKER_ID, null)
                application.notificationManager.cancelAll()
            }
        }
    }
}