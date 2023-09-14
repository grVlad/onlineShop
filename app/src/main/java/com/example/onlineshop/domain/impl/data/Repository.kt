package com.example.onlineshop.domain.impl.data

import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.model.AllProductList

interface Repository {
    suspend fun getAllProducts(): Response<AllProductList>
}