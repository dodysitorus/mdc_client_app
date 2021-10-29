package com.example.klinikapp.DataSource.Layanan.ViewModel

import androidx.lifecycle.ErrorMessages
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.klinikapp.DataSource.Layanan.Resource.*
import com.example.klinikapp.DataSource.Layanan.Response.LayananResponse
import com.example.klinikapp.DataSource.Layanan.Usecase.LayananUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LayananViewModel constructor(val layananUseCase : LayananUseCase) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val showLayanan = MutableLiveData<Resource<LayananResponse>>()

    fun showLayanan(){
        compositeDisposable.add(layananUseCase.showLayanan()
            .doOnSubscribe { showLayanan.setLoading()}
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    showLayanan.setSuccess(it)
                },
                {
                    showLayanan.setError(ErrorMessageUtility.generateMessage(it))
                }
            )
        )
    }
}