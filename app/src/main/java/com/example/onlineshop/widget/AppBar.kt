package com.example.onlineshop.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
) = TopAppBar(
    title = { Text(text = title) },
    modifier = Modifier
        .defaultMinSize(minHeight = 64.dp)
        .background(Color.Gray)
)

@Composable
@Preview
private fun Preview() = AppBar(title = "AppBar Title")