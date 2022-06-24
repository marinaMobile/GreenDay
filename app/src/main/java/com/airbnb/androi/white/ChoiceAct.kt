package com.airbnb.androi.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.androi.R
import com.airbnb.androi.white.rus.RuTestAct
import com.airbnb.androi.white.us.TestActivity
import kotlinx.android.synthetic.main.activity_choice.*

class ChoiceAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        lanUS.setOnClickListener{
            startActivity(Intent(this, TestActivity::class.java))
        }

        lanRU.setOnClickListener{
            startActivity(Intent(this, RuTestAct::class.java))
        }
    }
}