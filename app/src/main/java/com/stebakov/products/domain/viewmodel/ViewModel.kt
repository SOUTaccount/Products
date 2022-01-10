package com.stebakov.products.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.stebakov.products.domain.viewmodel.Model

class ViewModel(private val model: Model) : ViewModel() {

    suspend fun getPhoneHomeStore() = model.getPhoneHomeStore()

    suspend fun getPhoneBestSeller() = model.getPhoneBestSeller()

}