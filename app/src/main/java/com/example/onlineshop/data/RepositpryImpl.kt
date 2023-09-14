package com.example.onlineshop.data

import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.model.AllProductList
import com.example.onlineshop.domain.impl.data.Repository
import com.example.onlineshop.network.api.Api

internal class RepositoryImpl(private val api: Api) : Repository {

    override suspend fun getAllProducts(): Response<AllProductList> =
        try {
            val data = api.getAllProducts().toDomain()
            Response.Success(data)
        } catch (e: Exception) {
            Response.Failed(e)
        }
}
