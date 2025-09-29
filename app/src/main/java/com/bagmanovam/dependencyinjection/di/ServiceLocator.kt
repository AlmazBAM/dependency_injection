package com.bagmanovam.dependencyinjection.di

import android.content.Context
import com.bagmanovam.dependencyinjection.data.DataBase
import com.bagmanovam.dependencyinjection.data.ExampleRepositoryImpl
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase

object ServiceLocator {

    private var appContext: Context? = null

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    private fun getContext(): Context {
        return appContext ?: throw IllegalArgumentException("ServiceLocator not initialized. Call first init()")
    }

    private val database by lazy { DataBase(getContext()) }
    private val repository by lazy { ExampleRepositoryImpl(database) }
    private val exampleUseCase by lazy { ExampleUseCase(repository) }

//
//    fun provideDatabase(): DataBase {
//        return database
//    }
//
//    fun provideRepository(): ExampleRepository {
//        return repository
//    }

    fun provideExampleUseCase(): ExampleUseCase {
        return exampleUseCase
    }
}
