package com.example.klinikapp.DataSource.Layanan.RemoteDataSourceImpl

import com.example.klinikapp.DataSource.Domain.API
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import com.example.klinikapp.DataSource.Layanan.Source.LayananDataSource
import io.reactivex.Single

class LayananDataSourceImpl constructor(private val api : API):LayananDataSource {
    override fun showLayanan(): Single<LayananResponse> {
        return api.showLayanan()
    }
}