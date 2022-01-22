package com.stebakov.products.presentation.viewmodel.detail.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stebakov.products.presentation.viewmodel.detail.DetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel

class DetailViewModelFactory(private val detailModel: DetailModel) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(detailModel) as T
    }
}