package com.example.beelinepr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val recycler = findViewById<RecyclerView>(R.id.recycler)
            val layoutManager = LinearLayoutManager(this)
            val adapter = ActivityAdapter {
                when(it){
                    0 -> startActivity1()
                    1 -> startActivity2()
                    2 -> startActivity3()
                    3 -> startActivity4()
                }
            }

          recycler.layoutManager = layoutManager
          recycler.adapter = adapter
          recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

          val list = mutableListOf<String>()
          for (i in 0..2) {
              list.add("Activity ${i+1}")
          }
            list.add("Activity Lab 4(2)")
          adapter.setData(list)
     }


    private fun startActivity1() {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }

    private fun startActivity2() {
       val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    private fun startActivity3() {
        val intent = Intent(this, Activity3::class.java)
        startActivity(intent)
    }

    private fun startActivity4() {
        val intent = Intent(this, MainActivity1::class.java)
        startActivity(intent)
    }
}