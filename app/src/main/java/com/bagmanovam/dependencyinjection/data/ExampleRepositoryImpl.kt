package com.bagmanovam.dependencyinjection.data

import android.util.Log
import com.bagmanovam.dependencyinjection.domain.ExampleRepository
import com.bagmanovam.dependencyinjection.domain.Item
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor (
    private val dataBase: DataBase
) : ExampleRepository {

    override fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExampleRepositoryImpl: $item")

        dataBase.exampleMethod(item)
    }
}