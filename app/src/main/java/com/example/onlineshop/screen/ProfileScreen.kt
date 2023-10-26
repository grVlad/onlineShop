package com.example.onlineshop.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

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