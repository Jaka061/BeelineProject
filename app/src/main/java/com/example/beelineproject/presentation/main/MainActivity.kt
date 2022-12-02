package com.example.beelineproject.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.beelineproject.R
import com.example.beelineproject.databinding.ActivityMainBinding
import com.example.beelineproject.presentation.OnClick
import com.example.beelineproject.presentation.ui.AlbumFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClick {
    private lateinit var binding: ActivityMainBinding
    lateinit var clickView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            Log.e("main","ok")
            openFragment(AlbumFragment(),false)
        }
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}