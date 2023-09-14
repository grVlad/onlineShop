package com.example.onlineshop.di

import android.util.Log
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.logger.Logger
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.example.onlineshop.common.Mapper
import com.example.onlineshop.data.RepositoryImpl
import com.example.onlineshop.domain.api.MainStore
import com.example.onlineshop.domain.impl.MainStoreFactory
import com.example.onlineshop.domain.impl.data.Repository
import com.example.onlineshop.network.ClientProvider
import com.example.onlineshop.network.api.Api
import com.example.onlineshop.network.impl.ApiImpl
import com.example.onlineshop.presentation.MainViewModel
import com.example.onlineshop.presentation.mapper.MainUiStateMapper
import com.example.onlineshop.presentation.model.UiMainState
import org.koin.core.qualifier.named
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments")
internal val mainModule = module {

    factory<MainViewModel> {
        MainViewModel(
            store = get(),
            stateMapper = get(named("MainUiStateMapper")),
        )
    }

    factory<Mapper<MainStore.State, UiMainState>>(named("MainUiStateMapper")) {
        MainUiStateMapper()
    }

    factory<MainStore>() {
        MainStoreFactory(
            storeFactory = get(),
            repository = get(),
        ).create()
    }

    factory<StoreFactory> {
        val logger = object : Logger {
            override fun log(text: String) {
                Log.d("LoggingStoreFactory", text)
            }
        }
        LoggingStoreFactory(DefaultStoreFactory(), logger = logger)
    }

    factory<Repository>() {
        RepositoryImpl(get())
    }

    factory<Api>() {
        ApiImpl(get())
    }

    single {
        ClientProvider()
    }
}