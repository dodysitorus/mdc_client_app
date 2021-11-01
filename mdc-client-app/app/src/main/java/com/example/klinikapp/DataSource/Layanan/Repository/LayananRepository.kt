package com.example.klinikapp.DataSource.Layanan.Repository

import com.example.klinikapp.DataSource.BaseResponse
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import io.reactivex.Single

interface LayananRepository {
    fun showLayanan(): Single<LayananResponse>
}