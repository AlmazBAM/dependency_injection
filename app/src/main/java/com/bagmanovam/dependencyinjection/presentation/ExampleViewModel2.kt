package com.bagmanovam.dependencyinjection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.domain.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel2 @Inject constructor (
    private val exampleUseCase: ExampleUseCase,
): ViewModel() {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExampleViewModel: ")
        exampleUseCase(item)
    }
}