package com.stebakov.products.presentation.phonedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.data.model.PhoneServerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(private val detailModel: DetailModel) : ViewModel() {
    private var currentJob: Job? = null

    private val _phoneDetail = MutableLiveData<PhoneDetailServerModel>()
    val phoneDetail: LiveData<PhoneDetailServerModel>
        get() = _phoneDetail

    fun getDetail() {
        if (detailModel.getDetailPhoneUseCase.data == null) {
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _phoneDetail.postValue(detailModel.getDetail())
            }
                .also { currentJob = it }
        } else {
            _phoneDetail.postValue(detailModel.getDetailPhoneUseCase.data)
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancel()
        currentJob = null
    }
}