package com.stebakov.products.data

import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.data.model.PhoneServerModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhoneService {
    @Headers("x-apikey: " + "61ddae2e95cb716ea5ee48e4")
    @GET("home")
    suspend fun getPhone(): Response<List<PhoneServerModel>>

    @Headers("x-apikey: " + "61ddae2e95cb716ea5ee48e4")
    @GET("detail")
    suspend fun getDetail(): Response<List<PhoneDetailServerModel>>

    companion object{
        operator fun invoke() : PhoneService {
            return Retrofit.Builder()
                .baseUrl("https://shopapi-0575.restdb.io/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhoneService::class.java)
        }
    }
}