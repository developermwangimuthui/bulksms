package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.settings.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.settings.viewModel.SettingsFragmentViewModel
import com.intelligentsoftwares.bulksms.backend.MyCustomApplication


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

val settingsModule = module {

    viewModel { SettingsFragmentViewModel(androidApplication() as MyCustomApplication, get()) }
}