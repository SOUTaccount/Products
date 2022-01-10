package com.stebakov.products.data

import com.stebakov.products.data.model.PhoneServerModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhoneService {
    @Headers("x-apikey: " + "2aa8e910f6c4ade81a84c9333ffc7bf6a398e")
    @GET("main")
    suspend fun getPhone(): Response<List<PhoneServerModel>>

    companion object{
        operator fun invoke() : PhoneService {
            return Retrofit.Builder()
                .baseUrl("https://db2021ecom-edca.restdb.io/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhoneService::class.java)
        }
    }
}