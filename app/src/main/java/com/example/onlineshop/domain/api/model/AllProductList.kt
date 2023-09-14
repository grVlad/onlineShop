package com.example.onlineshop.domain.api.model

data class AllProductList(
    val items: List<AllProductsItem>
)

data class AllProductsItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

data class Rating(
    val count: Int,
    val rate: Double
)