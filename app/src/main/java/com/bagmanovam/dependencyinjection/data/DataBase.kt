package com.bagmanovam.dependencyinjection.data

import android.util.Log
import com.bagmanovam.dependencyinjection.domain.Item

class DataBase {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "DataBase: $item")
    }
}