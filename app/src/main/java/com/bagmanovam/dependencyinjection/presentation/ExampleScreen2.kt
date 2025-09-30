package com.bagmanovam.dependencyinjection.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.bagmanovam.dependencyinjection.domain.Item

@Composable
fun ExampleScreen2(
    modifier: Modifier = Modifier,
    viewModel: ExampleViewModel2 = hiltViewModel()
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                viewModel.exampleMethod(Item(0))
            }
        ) {
            Text(
                text = "Click me 2"
            )
        }
    }
}
