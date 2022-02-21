package com.stebakov.products.presentation.viewmodel.phone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.data.cache.Cache
import com.stebakov.domain.entity.database.FavoritePhone
import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhoneViewModel(private val phoneModel: PhoneModel) : ViewModel() {

    private var currentJob: Job? = null

    private val _phones = MutableLiveData<List<PhoneHomeStoreServerModel>>()
    val phones: LiveData<List<PhoneHomeStoreServerModel>>
        get() = _phones

    private val _phonesBestSeller = MutableLiveData<List<PhoneBestSellerServerModel>>()
    val phonesBestSeller: LiveData<List<PhoneBestSellerServerModel>>
        get() = _phonesBestSeller

    fun getPhone() {
        if (phoneModel.checkLocalData()) {
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _phones.postValue(phoneModel.getPhones())
                _phonesBestSeller.postValue(phoneModel.getPhonesBestSeller())
            }
                .also { currentJob = it }
        } else {
            _phones.postValue(phoneModel.getLocalDataHomeStore())
            _phonesBestSeller.postValue(phoneModel.getLocalDataBestSeller())
        }
    }

    fun addFavoritePhones() {
        viewModelScope.launch(Dispatchers.IO) {
            phoneModel.addFavoritePhones(phoneModel.getPhonesBestSeller())
        }
    }

    fun getAllFavoritePhones(cache: Cache): List<FavoritePhone>? {
        var favoritePhonesCache: List<FavoritePhone>? = null
        viewModelScope.launch(Dispatchers.IO) {
            favoritePhonesCache = cache.getFavoritePhones()
        }
        return favoritePhonesCache
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancel()
        currentJob = null
    }
}