package com.stebakov.products.data.repository

import android.util.Log
import com.stebakov.products.data.model.PhoneServerModel
import com.stebakov.products.data.PhoneService
import com.stebakov.products.domain.repository.PhoneCloudCallback
import com.stebakov.products.domain.repository.PhoneCloudDataSource
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class BasePhoneCloudDataSource(private val phoneService: PhoneService) : PhoneCloudDataSource {

    override fun getPhone(callback: PhoneCloudCallback) {
        phoneService.getPhone().enqueue(object : retrofit2.Callback<List<PhoneServerModel>> {
            override fun onResponse(
                call: Call<List<PhoneServerModel>>,
                response: Response<List<PhoneServerModel>>
            ) {
                try {
                    if (response.isSuccessful){
                        callback.provide(
                            response.body()!![0].toPhoneHomeStore(),
                            response.body()!![0].toPhoneBestSeller()
                        )
                        Log.d("RetrofitLog", "responce = ${response.body().toString()}")
                    }
                    else{
                        callback.fail()
                        Log.d("RetrofitLog", "FAIL responce = ${response.body().toString()}")
                    }
                } catch (e: Exception){
                    Log.d("RetrofitLog", "catch = ${response.body().toString()}")
                }
            }

            override fun onFailure(call: Call<List<PhoneServerModel>>, t: Throwable) {
                callback.fail()
                Log.d("RetrofitLog", "error is ${t.message}")
            }
        })
    }
}