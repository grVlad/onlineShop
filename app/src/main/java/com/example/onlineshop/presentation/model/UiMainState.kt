package com.example.onlineshop.presentation.model

import com.example.onlineshop.domain.api.model.Product

data class UiMainState(
    val allProductList: List<Product>? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)