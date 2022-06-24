package com.airbnb.androi.black

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.airbnb.androi.R
import com.airbnb.androi.white.ChoiceAct
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.*

class MoveMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_me)
        val textView: TextView = findViewById(R.id.txtMover)

        runBlocking {

            val job: Job = GlobalScope.launch(Dispatchers.IO) {
                getAsync(applicationContext)
            }
            job.join()
            val jsoup: String? = Hawk.get(CNST.aResult, "")
            Log.d("cora", "cora $jsoup")

            textView.text = jsoup

            if (jsoup == "6nDs") {
                Intent(applicationContext, ChoiceAct::class.java).also { startActivity(it) }

            } else {
                Intent(applicationContext, Webby::class.java).also { startActivity(it) }
            }
            finish()
        }
    }

    private suspend fun getAsync(context: Context) {
        val asyncKey = Soo(context)
        val asyncResult = asyncKey.getDocSecretKey()
        Hawk.put(CNST.aResult, asyncResult)
    }
}