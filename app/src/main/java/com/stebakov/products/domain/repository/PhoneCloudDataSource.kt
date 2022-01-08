package com.stebakov.products.domain.repository

interface PhoneCloudDataSource {

    fun getPhone(callback: PhoneCloudCallback)
}