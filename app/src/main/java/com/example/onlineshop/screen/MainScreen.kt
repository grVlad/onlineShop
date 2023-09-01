package com.example.onlineshop.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.R
import com.example.onlineshop.domain.api.model.UserInfo
import com.example.onlineshop.presentation.model.UiMainState
import com.example.onlineshop.ui.theme.buttonPrimaryActiveColor
import com.example.onlineshop.ui.theme.buttonPrimaryDisabledColor
import com.example.onlineshop.ui.theme.textPrimaryColor
import com.example.onlineshop.ui.theme.textSecondaryColor
import com.example.onlineshop.widget.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: UiMainState,
    onLoadClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(id = R.string.app_name),
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            val userInfo = state.userInfo

            when {
                state.loading -> CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = Color.Magenta,
                    strokeWidth = 3.dp
                )

                state.error -> {
                    ErrorState(
                        modifier = Modifier.align(Alignment.Center),
                        onLoadClick = onLoadClick
                    )
                }

                userInfo != null -> UserInfoDetails(
                    modifier = Modifier.align(Alignment.Center),
                    userInfo = userInfo,
                    onLoadClick = onLoadClick
                )
            }
        }
    }
}

@Composable
private fun ErrorState(
    onLoadClick: () -> Unit,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.error),
            fontSize = 20.sp,
            lineHeight = 28.sp,
        )
        MainButton(
            modifier = Modifier.padding(top = 4.dp),
            titleResId = R.string.reload,
            onClick = onLoadClick
        )
    }
}

@Composable
private fun MainButton(
    @StringRes titleResId: Int,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        border = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonPrimaryActiveColor,
            contentColor = textPrimaryColor,
            disabledContainerColor = buttonPrimaryDisabledColor,
            disabledContentColor = textSecondaryColor
        )
    ) {
        Text(
            text = stringResource(id = titleResId),
            fontSize = 16.sp
        )
    }
}

@Composable
private fun UserInfoDetails(
    userInfo: UserInfo,
    onLoadClick: () -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(text = "Имя")
        Text(text = userInfo.name)
        Text(text = "Фамилия")
        Text(text = userInfo.surname)
        Spacer(modifier = Modifier.height(4.dp))
        MainButton(titleResId = R.string.reload, onClick = onLoadClick, modifier = Modifier.padding(top = 4.dp))
    }
}