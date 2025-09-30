package com.bagmanovam.dependencyinjection.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.bagmanovam.dependencyinjection.domain.Item

@Composable
fun ExampleScreen(
    modifier: Modifier,
    viewModel: ExampleViewModel,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                viewModel.exampleMethod()
            }
        ) {
            Text(
                text = "Click me"
            )
        }
        ExampleScreen2()
    }

}
