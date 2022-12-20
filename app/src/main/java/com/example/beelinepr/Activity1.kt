package com.example.beelinepr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class Activity1 : AppCompatActivity()  {

    private lateinit var img : AppCompatImageView
    private lateinit var btn : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)

        img = findViewById(R.id.img1)
        btn = findViewById(R.id.button1)

        btn.setOnClickListener(){
            img.setImageResource(R.drawable.ic_baseline_cruelty_free_24)
        }
    }
}