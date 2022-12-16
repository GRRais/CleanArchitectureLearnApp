package ru.rayanis.cleanarchitecturelearnapp.app

import android.app.Application
import ru.rayanis.cleanarchitecturelearnapp.di.AppComponent
import ru.rayanis.cleanarchitecturelearnapp.di.AppModule
import ru.rayanis.cleanarchitecturelearnapp.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}