package com.example.onlineshop.network.impl

import com.example.onlineshop.network.ClientProvider
import com.example.onlineshop.network.HOST
import com.example.onlineshop.network.api.Api
import com.example.onlineshop.network.model.AllProductsDto
import com.example.onlineshop.network.model.AllProductsDtoItem
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ApiImpl(private val clientProvider: ClientProvider) : Api {
    override suspend fun getAllProducts(): AllProductsDto {
        val listProducts = clientProvider.client.get("${HOST}products").call.body<List<AllProductsDtoItem>>()
        return AllProductsDto(listProducts)
    }
}