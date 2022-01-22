package com.stebakov.products.presentation.viewmodel.phone.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stebakov.products.presentation.viewmodel.phone.PhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel

@Suppress("UNCHECKED_CAST")
class PhoneViewModelFactory(private val phoneModel: PhoneModel): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhoneViewModel(phoneModel) as T
    }
}