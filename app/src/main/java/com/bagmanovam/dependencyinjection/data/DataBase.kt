package com.bagmanovam.dependencyinjection.data

import android.annotation.SuppressLint
import android.content.Context
import android.provider.ContactsContract.Data
import android.util.Log
import com.bagmanovam.dependencyinjection.domain.Item

class DataBase private constructor(
    private val context: Context
) {

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "DataBase: $item $context")
    }

    companion object {
        private val LOCK = Any()
        private var instance: DataBase? = null
        fun getInstance(context: Context): DataBase {
            instance?.let { return it }
            synchronized(LOCK) {
                instance?.let { return it }
                return DataBase(context).also { instance = it }
            }
        }
    }
}