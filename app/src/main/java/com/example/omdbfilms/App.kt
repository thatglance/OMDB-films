package com.example.omdbfilms

import android.app.Application
import com.example.omdbfilms.di.AppComponent
import com.example.omdbfilms.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().bindApplication(this).build()
    }
}
