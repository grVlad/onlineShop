package com.example.onlineshop.network.model

import com.example.onlineshop.domain.api.model.AllProductList
import com.example.onlineshop.domain.api.model.AllProductsItem
import com.example.onlineshop.domain.api.model.Rating
import kotlinx.serialization.Serializable

data class AllProductsDto(
    val items: List<AllProductsDtoItem>
) {
    fun toDomain(): AllProductList = AllProductList(
        items.map { productDto ->
            AllProductsItem(
                id = productDto.id,
                title = productDto.title,
                category = productDto.category,
                description = productDto.description,
                image = productDto.image,
                price = productDto.price,
                rating = Rating(
                    count = productDto.rating.count,
                    rate = productDto.rating.rate
                )
            )
        }
    )
}

@Serializable
data class AllProductsDtoItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)

@Serializable
data class RatingDto(
    val count: Int,
    val rate: Double
)