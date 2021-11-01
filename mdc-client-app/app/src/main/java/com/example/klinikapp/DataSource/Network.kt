package com.example.klinikapp.DataSource

import android.app.Application
import com.example.klinikapp.BuildConfig
import com.example.klinikapp.DataSource.Domain.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {
    const val BASE_URL = "http://1c7f-116-206-31-62.ngrok.io/"

//    private val client = OkHttpClient
//        .Builder()
//        .build()
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()
//        .create(API::class.java)
//
//    fun buildService(): API {
//        return retrofit
//    }

}