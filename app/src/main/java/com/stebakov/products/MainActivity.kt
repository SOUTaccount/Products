package com.stebakov.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stebakov.products.domain.viewmodel.ViewModel
import com.stebakov.products.presentation.PhoneFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private val phoneFragment = PhoneFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("RetrofitLog", "MainCreate")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, phoneFragment)
            .commit()

    }
}