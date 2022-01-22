package com.stebakov.products.presentation.phonedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stebakov.products.domain.viewmodel.Model

class DetailViewModelFactory(private val detailModel: DetailModel) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(detailModel) as T
    }
}