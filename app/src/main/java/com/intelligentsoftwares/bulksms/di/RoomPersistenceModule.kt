package com.intelligentsoftwares.bulksms.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.intelligentsoftwares.bulksms.roomPersistence.BulkSmsDatabase


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

val roomModule = module {

    single {
        BulkSmsDatabase.getInstance(androidContext())
    }

    single {
        get<BulkSmsDatabase>().bulkSmsDao()
    }
}