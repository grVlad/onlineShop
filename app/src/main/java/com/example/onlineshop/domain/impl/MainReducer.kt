package com.example.onlineshop.domain.impl

import com.arkivanov.mvikotlin.core.store.Reducer
import com.example.onlineshop.domain.api.MainStore

class MainReducer : Reducer<MainStore.State, MainStoreFactory.Message> {
    override fun MainStore.State.reduce(msg: MainStoreFactory.Message): MainStore.State = when (msg) {
        is MainStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false
        )

        is MainStoreFactory.Message.SetAllProductList -> copy(
            allProductList = msg.allProductList,
            isLoading = false
        )

        is MainStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false
        )
    }
}