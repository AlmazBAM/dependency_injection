package com.bagmanovam.dependencyinjection.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bagmanovam.dependencyinjection.data.DataBase
import com.bagmanovam.dependencyinjection.data.ExampleRepositoryImpl
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.domain.Item
import com.bagmanovam.dependencyinjection.presentation.ui.theme.DependencyInjectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = DataBase()
        val repository = ExampleRepositoryImpl(database)
        val useCase = ExampleUseCase(repository)

        setContent {
            DependencyInjectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel =  viewModel {
                            ExampleViewModel(useCase)
                        })
                }
            }
        }
    }
}

@Composable
fun ExampleScreen(
    modifier: Modifier,
    viewModel: ExampleViewModel
    ) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewModel.exampleMethod(Item(0))
            }
        ) {
            Text(
                text = "Click me"
            )
        }
    }
}
