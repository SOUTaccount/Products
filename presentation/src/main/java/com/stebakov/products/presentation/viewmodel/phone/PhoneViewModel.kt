package com.stebakov.products.presentation.viewmodel.phone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.domain.entity.PhoneServerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhoneViewModel(private val phoneModel: PhoneModel) : ViewModel() {

    private var currentJob : Job? = null

    private val _phones = MutableLiveData<PhoneServerModel>()
    val phones: LiveData<PhoneServerModel>
        get() = _phones

    fun getPhone() {
        if (phoneModel.getPhonesUseCase.data == null){
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _phones.postValue(phoneModel.getPhones())
            }
                .also { currentJob = it }
        } else {
            _phones.postValue(phoneModel.getPhonesUseCase.data)
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancel()
        currentJob = null
    }
}