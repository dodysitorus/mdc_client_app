package com.example.klinikapp.DataSource.Layanan.Module

import com.example.klinikapp.BuildConfig
import com.example.klinikapp.DataSource.Domain.API
import com.example.klinikapp.DataSource.Layanan.RemoteDataSourceImpl.LayananCacheDataSourceImpl
import com.example.klinikapp.DataSource.Layanan.RemoteDataSourceImpl.LayananDataSourceImpl
import com.example.klinikapp.DataSource.Layanan.Repository.LayananRepository
import com.example.klinikapp.DataSource.Layanan.RepositoryImpl.LayananRepositoryImpl
import com.example.klinikapp.DataSource.Layanan.Source.LayananDataSource
import com.example.klinikapp.DataSource.Layanan.Usecase.LayananUseCase
import com.example.klinikapp.DataSource.Layanan.ViewModel.LayananViewModel
import com.example.klinikapp.DataSource.Network.BASE_URL
import com.example.klinikapp.Network.createNetworkClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadfeature

private val loadfeature by lazy {
    loadKoinModules(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        dataSourceModule,
        networkModule
    )
}

val viewModelModule = module {
    viewModel { LayananViewModel(get()) }
}

val useCaseModule = module {
    factory { LayananUseCase(repository = get()) }
}

val repositoryModule = module {
    single { LayananRepositoryImpl(dataSource = get()) as LayananRepository }
}

val dataSourceModule = module {
    single { LayananDataSourceImpl(api = get()) as LayananDataSource }
//    single { LayananCacheDataSourceImpl(preferencesHelper = get()) as LayananCacheDataSource }

}

val networkModule = module {
    single { createNetworkClient(BASE_URL, BuildConfig.DEBUG,androidApplication()).create(API::class.java) }
}
