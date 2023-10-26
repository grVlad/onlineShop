package com.example.onlineshop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.onlineshop.R
import com.example.onlineshop.domain.api.model.Product
import com.example.onlineshop.domain.api.model.Rating
import com.example.onlineshop.presentation.model.UiMainState
import com.example.onlineshop.ui.theme.cardContainerColor
import com.example.onlineshop.ui.theme.progressColor
import com.example.onlineshop.widget.ErrorPlaceholder
import com.example.onlineshop.widget.SimpleButton

@Composable
fun ProductListScreen(
    state: UiMainState,
    onLoadClick: () -> Unit,
    paddingValues: PaddingValues,
) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        val allProductList = state.allProductList

        when {
            state.loading -> CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center),
                color = progressColor,
                strokeWidth = 4.dp
            )

            state.error -> ErrorPlaceholder(
                modifier = Modifier
                    .align(Alignment.Center),
                onLoadClick = onLoadClick
            )

            allProductList != null -> Details(
                modifier = Modifier
                    .align(Alignment.Center),
                allProductList = allProductList
            )
        }
    }
}

@Composable
private fun Details(
    modifier: Modifier,
    allProductList: List<Product>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(allProductList) { item ->
            ProductItem(item)
        }
    }
}

@Composable
private fun ProductItem(
    item: Product
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(300.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = cardContainerColor
        )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.weight(0.9f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(0.6f)
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f)
                        .padding(top = 8.dp)
                        .padding(horizontal = 16.dp),
                    text = item.title,
                    fontSize = 16.sp,
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 16.dp)
                        .padding(start = 2.dp)
                        .padding(end = 16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(16.dp),
                        imageVector = Icons.Filled.Sell, contentDescription = null
                    )
                    Text(
                        text = item.price.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
            SimpleButton(
                titleResId = R.string.inCart,
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Details(
        modifier = Modifier.padding(), allProductList = listOf(
            Product(
                category = "Категория",
                description = "Описание",
                id = 0,
                image = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Android_logo_2019.png/800px-Android_logo_2019.png",
                price = 100.0,
                rating = Rating(count = 5, rate = 4.0),
                title = "Название"
            )
        )
    )
}