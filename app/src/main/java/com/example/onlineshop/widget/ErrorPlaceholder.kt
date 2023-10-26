package com.example.onlineshop.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.R

@Composable
fun ErrorPlaceholder(
    modifier: Modifier,
    onLoadClick: () -> Unit,
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
        SimpleButton(
            modifier = Modifier.padding(top = 4.dp),
            titleResId = R.string.reload,
            onClick = onLoadClick
        )
    }
}