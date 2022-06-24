package com.airbnb.androi.white.us

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.androi.R
import com.airbnb.androi.white.DataClass
import com.airbnb.androi.white.RVAd
import kotlinx.android.synthetic.main.activity_finish_ru.*

class FinishUS : AppCompatActivity() {
    val data = listOf(
        DataClass(R.drawable.porridge,"Porridge"),
        DataClass(R.drawable.fish,"Fish"),
        DataClass(R.drawable.food,"Vegetables"),
        DataClass(R.drawable.nutr,"Smoothies"),
        DataClass(R.drawable.nuts,"Nuts"),

        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_us)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RVAd(data)
    }
}