package ru.rayanis.cleanarchitecturelearnapp.di

import dagger.Component
import ru.rayanis.cleanarchitecturelearnapp.presentation.MainActivity

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}