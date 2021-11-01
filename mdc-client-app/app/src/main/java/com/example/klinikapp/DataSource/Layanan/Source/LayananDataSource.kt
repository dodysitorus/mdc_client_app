package com.example.klinikapp.DataSource.Layanan.Source

import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import io.reactivex.Single

interface LayananDataSource {
    fun showLayanan():Single<LayananResponse>
}

//interface LayananCacheDataSource {
//}

