package com.example.onlineshop.widget

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onlineshop.R
import com.example.onlineshop.presentation.model.UiMainState
import com.example.onlineshop.screen.CartScreen
import com.example.onlineshop.screen.FavoriteScreen
import com.example.onlineshop.screen.ProductListScreen
import com.example.onlineshop.screen.ProfileScreen

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object ProductList : BottomNavigationScreens("ProductList", R.string.productList, Icons.Filled.Home)
    object Favorite : BottomNavigationScreens("Favorite", R.string.favorite, Icons.Filled.Favorite)
    object Cart : BottomNavigationScreens("Cart", R.string.cart, Icons.Filled.ShoppingCart)
    object Profile : BottomNavigationScreens("Profile", R.string.profile, Icons.Filled.Person)
}

@Composable
fun NavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    state: UiMainState,
    onLoadClick: () -> Unit
) {
    NavHost(navController = navHostController, startDestination = BottomNavigationScreens.ProductList.route) {
        composable(BottomNavigationScreens.ProductList.route) {
            ProductListScreen(
                state = state,
                onLoadClick = onLoadClick,
                paddingValues
            )
        }
        composable(BottomNavigationScreens.Favorite.route) {
            FavoriteScreen()
        }
        composable(BottomNavigationScreens.Cart.route) {
            CartScreen()
        }
        composable(BottomNavigationScreens.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomNavigationScreens.ProductList,
        BottomNavigationScreens.Favorite,
        BottomNavigationScreens.Cart,
        BottomNavigationScreens.Profile,
    )

    NavigationBar(
        modifier = Modifier.background(Color.White)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route ?: BottomNavigationScreens.ProductList

        listItems.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = "")
                },
                label = {
                    Text(stringResource(id = screen.title))
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route)
                }
            )
        }
    }
}