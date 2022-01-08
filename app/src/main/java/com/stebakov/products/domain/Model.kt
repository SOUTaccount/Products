package com.stebakov.products.domain

import com.stebakov.products.domain.callback.PhoneCallback

interface Model {
    fun getPhone()
    fun init(callback: PhoneCallback)
    fun clear()
}