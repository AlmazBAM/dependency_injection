package com.bagmanovam.dependencyinjection.domain

import android.util.Log
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repository: ExampleRepository
) {
    operator fun invoke(item: Item) {
        Log.d("ExampleTest", "ExampleUseCase: $item")
        repository.exampleMethod(item)
    }
}