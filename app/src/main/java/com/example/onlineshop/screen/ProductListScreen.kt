package com.example.onlineshop.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.onlineshop.presentation.model.UiMainState

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
    }
}

@Composable
fun FavoriteScreen() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Избранное",
        textAlign = TextAlign.Center
    )
}

@Composable
fun CartScreen() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Корзина",
        textAlign = TextAlign.Center
    )
}

@Composable
fun ProfileScreen() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Профиль",
        textAlign = TextAlign.Center
    )
}