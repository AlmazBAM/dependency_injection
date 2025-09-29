package com.bagmanovam.dependencyinjection

import android.app.Application
import com.bagmanovam.dependencyinjection.di.ServiceLocator

class ExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
    }
}