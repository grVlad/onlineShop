package com.example.onlineshop.network.api

import com.example.onlineshop.network.model.AllProductsDto

interface Api {
    suspend fun getAllProducts(): AllProductsDto
}