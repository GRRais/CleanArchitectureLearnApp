package ru.rayanis.cleanarchitecturelearnapp.app

import android.app.Application
import ru.rayanis.cleanarchitecturelearnapp.di.AppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
    }
}