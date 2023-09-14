package com.example.onlineshop.domain.api

import com.arkivanov.mvikotlin.core.store.Store

interface MainStore : Store<MainStore.Intent, MainStore.State, Nothing> {

    data class State constructor(
        val details: UserInfo? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )

    sealed interface Intent {
        object Load : Intent
    }
}