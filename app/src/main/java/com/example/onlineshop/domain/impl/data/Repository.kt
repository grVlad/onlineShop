package com.example.onlineshop.domain.impl.data

import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.model.Product

interface Repository {
    suspend fun getAllProducts(): Response<List<Product>>
}