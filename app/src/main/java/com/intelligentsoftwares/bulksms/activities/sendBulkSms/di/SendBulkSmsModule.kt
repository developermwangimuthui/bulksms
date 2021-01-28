package com.intelligentsoftwares.bulksms.activities.sendBulkSms.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.intelligentsoftwares.bulksms.activities.sendBulkSms.viewModel.SendBulkSmsViewModel
import com.intelligentsoftwares.bulksms.backend.MyCustomApplication


/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/27/19}
 */

val sendBulkSmsModule = module {

    viewModel { SendBulkSmsViewModel(androidApplication() as MyCustomApplication, get(), get()) }
}