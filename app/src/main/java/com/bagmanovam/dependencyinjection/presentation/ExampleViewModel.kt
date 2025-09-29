package com.bagmanovam.dependencyinjection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.domain.Item

class ExampleViewModel(
    private val exampleUseCase: ExampleUseCase
): ViewModel() {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExampleViewModel: $item")
        exampleUseCase(item)
    }

    class Factory(
        private val useCase: ExampleUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ExampleViewModel::class.java))
                return ExampleViewModel(useCase) as T
            throw IllegalArgumentException("Unknown viewmodel class ${modelClass.name}")
        }
    }
}