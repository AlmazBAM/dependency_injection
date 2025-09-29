package com.bagmanovam.dependencyinjection.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bagmanovam.dependencyinjection.data.DataBase
import com.bagmanovam.dependencyinjection.data.ExampleRepositoryImpl
import com.bagmanovam.dependencyinjection.domain.ExampleUseCase
import com.bagmanovam.dependencyinjection.presentation.ExampleViewModel

object ServiceLocator {

    private val database by lazy { DataBase() }
    private val repository by lazy { ExampleRepositoryImpl(database) }
    private val exampleUseCase = ExampleUseCase(repository)
    val exampleViewModel by lazy { ExampleViewModel(exampleUseCase) }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(ExampleViewModel::class.java))
                    return ExampleViewModel(exampleUseCase) as T
                throw IllegalArgumentException("Unknown viewModel class")
            }
        }
    }

}
