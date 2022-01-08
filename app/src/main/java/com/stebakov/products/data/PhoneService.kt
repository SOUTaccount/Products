package com.stebakov.products.data

import com.stebakov.products.data.model.PhoneServerModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhoneService {
    @Headers("x-apikey: " + "2aa8e910f6c4ade81a84c9333ffc7bf6a398e")
    @GET("main")
    fun getPhone(): Call<List<PhoneServerModel>>
}