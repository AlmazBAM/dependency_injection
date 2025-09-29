package com.bagmanovam.dependencyinjection

import android.app.Application
import com.bagmanovam.dependencyinjection.di.ServiceLocator
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
    }
}