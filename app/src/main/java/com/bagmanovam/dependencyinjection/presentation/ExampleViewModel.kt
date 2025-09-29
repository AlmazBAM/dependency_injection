package com.bagmanovam.dependencyinjection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.domain.Item
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class ExampleViewModel @AssistedInject constructor (
    private val exampleUseCase: ExampleUseCase,
    @Assisted("item") private val item: Item
): ViewModel() {

    fun exampleMethod() {
        Log.d("ExampleTest", "ExampleViewModel: $item")
        exampleUseCase(item)
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("item") item: Item): ExampleViewModel
    }

    class FactoryProvider(
        private val useCase: ExampleUseCase,
        private val item: Item
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ExampleViewModel::class.java))
                return ExampleViewModel(useCase, item) as T
            throw IllegalArgumentException("Unknown viewmodel class ${modelClass.name}")
        }
    }
}