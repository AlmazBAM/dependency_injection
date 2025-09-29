package com.bagmanovam.dependencyinjection.data

import android.content.Context
import android.util.Log
import com.bagmanovam.dependencyinjection.domain.Item

class DataBase(private val context: Context) {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "DataBase: $item $context")
    }
}