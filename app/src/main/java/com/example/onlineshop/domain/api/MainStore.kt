package com.example.onlineshop.domain.api

import com.arkivanov.mvikotlin.core.store.Store
import com.example.onlineshop.domain.api.model.AllProductList

interface MainStore : Store<MainStore.Intent, MainStore.State, Nothing> {

    data class State constructor(
        val allProductList: AllProductList? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

    sealed interface Intent {
        object Load : Intent
    }
}