package com.airbnb.androi.white.rus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.androi.R
import com.airbnb.androi.white.DataClass
import com.airbnb.androi.white.RVAd
import kotlinx.android.synthetic.main.activity_finish_ru.*

class FinishRu : AppCompatActivity() {
    val data = listOf(
        DataClass(R.drawable.porridge,"Каша"),
        DataClass(R.drawable.fish,"Рыба"),
        DataClass(R.drawable.food,"Овощи"),
        DataClass(R.drawable.nutr,"Смузи"),
        DataClass(R.drawable.nuts,"Орехи"),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_ru)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RVAd(data)
    }
}