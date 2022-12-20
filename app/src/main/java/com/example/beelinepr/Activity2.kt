package com.example.beelinepr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class Activity2 : AppCompatActivity()  {

    private lateinit var img : AppCompatImageView
    private lateinit var btn : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        img = findViewById(R.id.img2)
        btn = findViewById(R.id.button2)

        btn.setOnClickListener(){
            img.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24)
        }
    }
}