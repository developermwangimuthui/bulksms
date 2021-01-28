package com.intelligentsoftwares.bulksms.di

import android.content.Context
import org.koin.dsl.module
import com.intelligentsoftwares.bulksms.helper.SharedPreferenceHelper
import com.intelligentsoftwares.bulksms.helper.UiHelper


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

private const val USER_SHARED_PREFERENCE = "spartons.com.prosmssenderapp_user_shared_preference"

val utilModule = module {

    single { UiHelper() }

    single {
        val sharedPreference =
            get<Context>().getSharedPreferences(USER_SHARED_PREFERENCE, Context.MODE_PRIVATE)
        SharedPreferenceHelper(sharedPreference)
    }
}
