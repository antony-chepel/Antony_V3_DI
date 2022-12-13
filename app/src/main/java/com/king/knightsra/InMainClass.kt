package com.king.knightsra

import android.app.Application
import com.king.knightsra.constans.ConstanceAppClass.osNal
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class InMainClass : Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(osNal)
        Hawk.init(this).build()
    }
}
