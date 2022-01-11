package com.stebakov.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stebakov.products.presentation.PhoneFragment

class MainActivity : AppCompatActivity() {

    private val phoneFragment = PhoneFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, phoneFragment)
            .commit()
    }
}