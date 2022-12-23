package ru.rayanis.cleanarchitecturelearnapp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.rayanis.cleanarchitecturelearnapp.di.appModule
import ru.rayanis.cleanarchitecturelearnapp.di.dataModule
import ru.rayanis.cleanarchitecturelearnapp.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}