package com.bagmanovam.dependencyinjection.domain

import android.util.Log

class ExampleUseCase(private val repository: ExampleRepository) {
    operator fun invoke(item: Item) {
        Log.d("ExampleTest", "ExampleUseCase: $item")
        repository.exampleMethod(item)
    }
}