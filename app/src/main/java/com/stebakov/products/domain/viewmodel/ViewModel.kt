package com.stebakov.products.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(private val model: Model) : ViewModel() {

    private val _phoneHomeStore = MutableLiveData<MutableList<PhoneHomeStore>>()
    val phoneHomeStore: LiveData<MutableList<PhoneHomeStore>>
        get() = _phoneHomeStore

    private val _phoneBestSeller = MutableLiveData<MutableList<PhoneBestSeller>>()
    val phoneBestSeller: LiveData<MutableList<PhoneBestSeller>>
        get() = _phoneBestSeller

    fun getPhone() {
        CoroutineScope(Dispatchers.Main).launch {
            _phoneHomeStore.value = model.getPhoneHomeStore()
            _phoneBestSeller.value = model.getPhoneBestSeller()
        }
    }
}