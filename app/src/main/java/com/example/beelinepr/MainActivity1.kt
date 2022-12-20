package com.example.beelinepr

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity1 : AppCompatActivity() {

    private lateinit var name : AppCompatEditText
    private lateinit var number: AppCompatEditText
    private lateinit var btn : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val intent = Intent(this, MainActivity2::class.java)

        name = findViewById(R.id.editName)
        number = findViewById(R.id.editNum)
        btn = findViewById(R.id.button)

        if (!name.text.isNullOrEmpty() && !number.text.isNullOrEmpty()) {
            Toast.makeText(this, "Empty or null", Toast.LENGTH_LONG).show()
        }
        else {
            btn.setOnClickListener() {
                val name = name.text.toString()
                val num = number.text.toString()

                intent.putExtra("name", " $name")
                intent.putExtra("number", " $num")

                startActivity(intent)
            }
        }
    }
}