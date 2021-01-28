package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.history.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.history.viewModel.HistoryFragmentViewModel
import com.intelligentsoftwares.bulksms.backend.MyCustomApplication


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

val historyModule = module {

    viewModel {
        HistoryFragmentViewModel(
            androidApplication() as MyCustomApplication,
            get(),
            get()
        )
    }

}