package com.example.onlineshop.presentation.mapper

import com.example.onlineshop.common.Mapper
import com.example.onlineshop.domain.api.MainStore
import com.example.onlineshop.presentation.model.UiMainState

internal class MainUiStateMapper : Mapper<MainStore.State, UiMainState> {

    override fun map(item: MainStore.State) = UiMainState(
        userInfo = item.details,
        loading = item.isLoading,
        error = item.isError,
    )
}
