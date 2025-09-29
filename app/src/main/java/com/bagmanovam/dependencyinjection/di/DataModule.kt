package com.bagmanovam.dependencyinjection.di

import android.content.Context
import com.bagmanovam.dependencyinjection.data.DataBase
import com.bagmanovam.dependencyinjection.data.ExampleRepositoryImpl
import com.bagmanovam.dependencyinjection.domain.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository

    companion object {

        @Singleton
        @Provides
        fun provideDatabase(@ApplicationContext context: Context): DataBase {
            return DataBase.getInstance(context)
        }
    }
}