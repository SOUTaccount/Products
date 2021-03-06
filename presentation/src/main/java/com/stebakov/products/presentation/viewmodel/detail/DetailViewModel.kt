package com.stebakov.products.presentation.viewmodel.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.domain.entity.network.PhoneDetailServerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(private val detailModel: DetailModel) : ViewModel() {
    private var currentJob: Job? = null

    private val _phoneDetail = MutableLiveData<PhoneDetailServerModel>()
    val phoneDetail: LiveData<PhoneDetailServerModel>
        get() = _phoneDetail

    fun getDetail() {
        if (detailModel.checkLocalData()) {
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _phoneDetail.postValue(detailModel.getDetail())
            }
                .also { currentJob = it }
        } else {
            _phoneDetail.postValue(detailModel.getLocalDataDetailPhone())
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancel()
        currentJob = null
    }
}