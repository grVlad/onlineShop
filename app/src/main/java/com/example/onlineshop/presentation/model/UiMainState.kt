package com.example.onlineshop.presentation.model

data class UiMainState(
    val userInfo: UserInfo? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)