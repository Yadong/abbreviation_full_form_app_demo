package com.abbreviationdemo

import android.app.Application
import com.abbreviationdemo.dependencies.AppComponent
import com.abbreviationdemo.dependencies.DaggerAppComponent

class AbbreviationDemoApp: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .build()
    }
}
