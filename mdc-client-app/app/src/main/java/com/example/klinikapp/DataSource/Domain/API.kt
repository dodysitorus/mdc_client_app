package com.example.klinikapp.DataSource.Domain

import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("api/layanan")
    fun showLayanan(): Single<LayananResponse>

}