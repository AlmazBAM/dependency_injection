package com.bagmanovam.dependencyinjection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.domain.Item

class ExampleViewModel(
    private val exampleUseCase: ExampleUseCase
): ViewModel() {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExampleViewModel: $item")
        exampleUseCase(item)
    }
}