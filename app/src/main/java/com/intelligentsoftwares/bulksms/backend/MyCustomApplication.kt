package com.intelligentsoftwares.bulksms.backend

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.history.di.historyModule
import com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments.settings.di.settingsModule
import com.intelligentsoftwares.bulksms.activities.sendBulkSms.di.sendBulkSmsModule
import com.intelligentsoftwares.bulksms.di.roomModule
import com.intelligentsoftwares.bulksms.di.utilModule
import com.intelligentsoftwares.bulksms.util.notificationManager
import timber.log.Timber

/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

class MyCustomApplication : MultiDexApplication() {

    companion object {
        const val APPLICATION_CHANNEL = "spartons.com.prosmssenderapp.send_sms_notification"
        private const val APPLICATION_NOTIFICATION = "Send Sms Notification"
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyCustomApplication)
            modules(
                listOf(
                    roomModule, utilModule, settingsModule, historyModule, sendBulkSmsModule
                )
            )
        }
        Fabric.with(this, Crashlytics())
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChannels()
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun createChannels() {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val applicationNotification = NotificationChannel(
            APPLICATION_CHANNEL,
            APPLICATION_NOTIFICATION, NotificationManager.IMPORTANCE_DEFAULT
        )
        applicationNotification.enableLights(true)
        applicationNotification.lightColor = Color.RED
        applicationNotification.setShowBadge(true)
        applicationNotification.setSound(uri, null)
        applicationNotification.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        notificationManager.createNotificationChannel(applicationNotification)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}