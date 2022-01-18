package com.desarrollodroide.simplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.desarrollodroide.simplecompose.ui.list.HomeScreen
import com.desarrollodroide.simplecompose.ui.theme.SimpleComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @VisibleForTesting
    internal val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}
