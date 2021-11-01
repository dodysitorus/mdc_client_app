package com.example.klinikapp.DataSource.Layanan.RepositoryImpl

import com.example.klinikapp.DataSource.BaseResponse
import com.example.klinikapp.DataSource.Layanan.Repository.LayananRepository
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import com.example.klinikapp.DataSource.Layanan.Source.LayananDataSource
import io.reactivex.Single

class LayananRepositoryImpl constructor(
    private val dataSource: LayananDataSource,
):LayananRepository {
    override fun showLayanan():Single<LayananResponse> {
        return dataSource.showLayanan()
    }
}