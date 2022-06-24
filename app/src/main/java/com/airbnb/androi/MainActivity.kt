package com.airbnb.androi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.airbnb.androi.black.CNST
import com.airbnb.androi.black.CNST.DL1
import com.airbnb.androi.black.CNST.DL2
import com.airbnb.androi.black.CNST.DL3
import com.airbnb.androi.black.CNST.DL4
import com.airbnb.androi.black.CNST.DL5
import com.airbnb.androi.black.CNST.DL6
import com.airbnb.androi.black.CNST.DL7
import com.airbnb.androi.black.CNST.DL8
import com.airbnb.androi.black.MoveMe
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.orhanobut.hawk.Hawk
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var stringH: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)

        if (prefs.getBoolean("activity_exec", false)) {
            Intent(this, MoveMe::class.java).also { startActivity(it) }
            finish()
        } else {
            val exec = prefs.edit()
            exec.putBoolean("activity_exec", true)
            exec.apply()
        }
    }

    override fun onResume() {
        super.onResume()
        appsIntegration()

    }

    fun mc() {
        Intent(this, MoveMe::class.java)
            .also { startActivity(it) }
        finish()
    }

    private fun appLin() {
        AppLinkData.fetchDeferredAppLinkData(
            this
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params =
                    appLinkData.targetUri!!.pathSegments
                Log.d("D11PL", "$params")
                val conjoined = TextUtils.join("/", params)
                val tokenizer = StringTokenizer(conjoined, "/")
                val firstLink = tokenizer.nextToken()
                val secondLink = tokenizer.nextToken()
                val thirdLink = tokenizer.nextToken()
                val fourthLink = tokenizer.nextToken()
                val fifthLink = tokenizer.nextToken()
                val sixthLink = tokenizer.nextToken()
                val seventhLink = tokenizer.nextToken()
                val eightLink = tokenizer.nextToken()
                Hawk.put(DL1, firstLink)
                Hawk.put(DL2, secondLink)
                Hawk.put(DL3, thirdLink)
                Hawk.put(DL4, fourthLink)
                Hawk.put(DL5, fifthLink)
                Hawk.put(DL6, sixthLink)
                Hawk.put(DL7, seventhLink)
                Hawk.put(DL8, eightLink)
                Hawk.put(CNST.FULL_DEEPLINK, conjoined)

                mc()
                finish()
            }
            if (appLinkData == null){
                Log.d("FB_TEST:", "Params = null")
                mc()
                finish()
            }
        }
    }

    private fun normalizer(str: String):String{
        if(str[0] == '[')
            return str.substring(1, str.length-1).replace("][", "_")
        else
            return str
    }

    private fun appsIntegration() {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: Map<String, Any>) {
                Log.d("TESTING_ZONE", "af stat is " + data["af_status"])
                stringH = (data["campaign"] as String?)!!
                Log.d("NAMING", "campaign attributed: $stringH")
                val tokenizer = StringTokenizer(normalizer(stringH), "_")
                val one = tokenizer.nextToken()
                val two = tokenizer.nextToken()
                val three = tokenizer.nextToken()
                val four = tokenizer.nextToken()
                val five = tokenizer.nextToken()
                val six = tokenizer.nextToken()
                val seven = tokenizer.nextToken()
                val eight = tokenizer.nextToken()
                Hawk.put(CNST.C11, one)
                Hawk.put(CNST.C22, two)
                Hawk.put(CNST.C33, three)
                Hawk.put(CNST.C44, four)
                Hawk.put(CNST.C55, five)
                Hawk.put(CNST.C66, six)
                Hawk.put(CNST.C77, seven)
                Hawk.put(CNST.C88, eight)
                Hawk.put(CNST.FULL_NAMING, stringH)
                appLin()
                mc()
                finish()
            }

            override fun onConversionDataFail(error: String?) {
                Log.e("LOG_TAG", "error onAttributionFailure :  $error")
                appLin()
                mc()
                finish()
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d("LOG_TAG", "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e("LOG_TAG", "error onAttributionFailure :  $error")
            }
        }
        AppsFlyerLib.getInstance().init(CNST.AF_DEV_KEY, conversionDataListener, applicationContext)
        AppsFlyerLib.getInstance().start(this)
    }
}