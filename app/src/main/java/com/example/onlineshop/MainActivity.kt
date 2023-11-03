package com.example.onlineshop

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.onlineshop.presentation.MainViewModel
import com.example.onlineshop.screen.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by viewModel.state.collectAsState()

            MainScreen(
                state = state,
                onLoadClick = viewModel::load,
                onHelpClick = viewModel::help,
            )
        }

        viewModel.label.observe(this) { text ->
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}