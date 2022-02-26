package com.stebakov.products.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stebakov.products.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Products)
        setContentView(R.layout.activity_main)
    }
}