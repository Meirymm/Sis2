package com.example.sis2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sis2.ui.theme.SIS2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SIS2Theme {

                // 🔥 Здесь уже внутри @Composable — можно вызывать viewModel()

                val viewModel: FeedViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        @Suppress("UNCHECKED_CAST")
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return FeedViewModel(SavedStateHandle()) as T
                        }
                    }
                )

                FeedScreen(viewModel = viewModel)
            }
        }
    }
}
