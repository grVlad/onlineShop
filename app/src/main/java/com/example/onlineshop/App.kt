package com.example.onlineshop

import android.app.Application
import com.example.onlineshop.di.initKoin
import org.koin.android.ext.koin.androidContext

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(applicationContext)
        }
    }
}