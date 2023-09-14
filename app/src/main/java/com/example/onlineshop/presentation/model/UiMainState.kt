package com.example.onlineshop.presentation.model

import com.example.onlineshop.domain.api.model.AllProductList

data class UiMainState(
    val allProductList: AllProductList? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)