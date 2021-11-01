package com.example.klinikapp.DataSource.Layanan.Usecase

import com.example.klinikapp.DataSource.BaseResponse
import com.example.klinikapp.DataSource.Layanan.Repository.LayananRepository
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import io.reactivex.Single

class LayananUseCase constructor(private val repository : LayananRepository) {

    fun showLayanan():Single<LayananResponse> = repository.showLayanan()
}