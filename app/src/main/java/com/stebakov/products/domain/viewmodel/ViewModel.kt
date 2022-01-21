package com.stebakov.products.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.products.data.model.PhoneServerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ViewModel(private val model: Model) : ViewModel() {

    private var currentJob : Job? = null

    private val _phones = MutableLiveData<PhoneServerModel>()
    val phones: LiveData<PhoneServerModel>
        get() = _phones

    fun getPhone() {
        if (model.getPhonesUseCase.data == null){
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _phones.postValue(model.getPhones())
            }
                .also { currentJob = it }
        } else {
            _phones.postValue(model.getPhonesUseCase.data)
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancel()
        currentJob = null
    }
}