package com.airbnb.androi.black

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppClass: Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(CNST.ONESIGNAL_APP_ID)
        GlobalScope.launch(Dispatchers.IO) {
            applyDeviceId(context = applicationContext)
        }
        Hawk.init(this).build()
    }

    private suspend fun applyDeviceId(context: Context) {
        val advertisingInfo = Data(context)
        val idInfo = advertisingInfo.getAdvertisingId()
        Hawk.put(CNST.MAIN_ID, idInfo)
    }
}