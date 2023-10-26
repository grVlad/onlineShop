package com.example.onlineshop.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.presentation.model.UiMainState
import com.example.onlineshop.widget.BottomNavigation
import com.example.onlineshop.widget.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: UiMainState,
    onLoadClick: () -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavGraph(
            navHostController = navController,
            paddingValues = paddingValues,
            state = state,
            onLoadClick = onLoadClick,
        )
    }
}