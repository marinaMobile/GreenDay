package com.airbnb.androi.black

import android.content.Context
import com.airbnb.androi.black.CNST.C11
import com.airbnb.androi.black.CNST.DL1
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class Soo (val context: Context) {

    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(C11,"null")
    private val hawkTheII : String? = Hawk.get(DL1, "null")
    private var forJsoupSet: String = CNST.mainU + CNST.carryMe + hawk + "&" + CNST.carryMeTwice + hawkTheII

    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            val doc = Jsoup.connect(forJsoupSet).get()
            jsoup = doc.text().toString()
        }
        return jsoup
    }
}