package com.example.onlineshop.widget

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.theme.buttonContentColor
import com.example.onlineshop.ui.theme.buttonPrimaryActiveColor
import com.example.onlineshop.ui.theme.buttonPrimaryDisabledColor
import com.example.onlineshop.ui.theme.textSecondaryColor

@Composable
fun SimpleButton(
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
            contentColor = buttonContentColor,
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