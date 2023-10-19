package com.example.onlineshop.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.domain.api.model.AllProductList
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

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(
//    state: UiMainState,
//    onLoadClick: () -> Unit
//) {
//    Scaffold(
//        topBar = {
//            AppBar(
//                title = stringResource(id = R.string.app_name),
//            )
//        },
//    ) { paddingValues ->
//        Box(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize()
//        ) {
//            val allProductList = state.allProductList
//
//            when {
//                state.loading -> CircularProgressIndicator(
//                    modifier = Modifier
//                        .align(Alignment.Center),
//                    color = Color.Magenta,
//                    strokeWidth = 3.dp
//                )
//
//                state.error -> {
//                    ErrorState(
//                        modifier = Modifier.align(Alignment.Center),
//                        onLoadClick = onLoadClick
//                    )
//                }
//
//                allProductList != null -> UserInfoDetails(
//                    modifier = Modifier.align(Alignment.Center),
//                    allProductList = allProductList,
//                    onLoadClick = onLoadClick
//                )
//            }
//        }
//    }
//}

//@Composable
//private fun ErrorState(
//    onLoadClick: () -> Unit,
//    modifier: Modifier,
//) {
//    Column(
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = stringResource(id = R.string.error),
//            fontSize = 20.sp,
//            lineHeight = 28.sp,
//        )
//        MainButton(
//            modifier = Modifier.padding(top = 4.dp),
//            titleResId = R.string.reload,
//            onClick = onLoadClick
//        )
//    }
//}

//@Composable
//private fun MainButton(
//    @StringRes titleResId: Int,
//    onClick: () -> Unit,
//    modifier: Modifier,
//) {
//    Button(
//        modifier = modifier,
//        onClick = onClick,
//        shape = RoundedCornerShape(12.dp),
//        border = null,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = buttonPrimaryActiveColor,
//            contentColor = textPrimaryColor,
//            disabledContainerColor = buttonPrimaryDisabledColor,
//            disabledContentColor = textSecondaryColor
//        )
//    ) {
//        Text(
//            text = stringResource(id = titleResId),
//            fontSize = 16.sp
//        )
//    }
//}

@Composable
private fun UserInfoDetails(
    allProductList: AllProductList,
    onLoadClick: () -> Unit,
    modifier: Modifier
) {
//    Column(
//        modifier = modifier,
//    ) {
//        Text(text = "Имя")
//        Text(text = allProductList.name)
//        Text(text = "Фамилия")
//        Text(text = allProductList.surname)
//        Spacer(modifier = Modifier.height(4.dp))
//        MainButton(titleResId = R.string.reload, onClick = onLoadClick, modifier = Modifier.padding(top = 4.dp))
//    }
}