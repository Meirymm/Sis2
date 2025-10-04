package com.example.sis2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sis2.ui.theme.SIS2Theme

class MainActivity : ComponentActivity() {

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SIS2Theme() {
                FeedScreen(viewModel = viewModel)
            }
        }
    }
}
