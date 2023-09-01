package com.example.onlineshop.presentation.model

import com.example.onlineshop.domain.api.model.UserInfo

data class UiMainState(
    val userInfo: UserInfo? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)