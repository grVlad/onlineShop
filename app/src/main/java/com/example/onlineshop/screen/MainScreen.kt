package com.example.onlineshop.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.model.UiMainState
import com.example.onlineshop.widget.BottomNavigation
import com.example.onlineshop.widget.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: UiMainState,
    onLoadClick: () -> Unit,
    onHelpClick: () -> Unit,
) {
    val navController = rememberNavController()
    Scaffold(

        topBar = {
            TopAppBar(
                { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(onClick = onHelpClick) {
                        Icon(imageVector = Icons.Outlined.HelpOutline, contentDescription = null)
                    }
                }
            )
        },
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