package ru.rayanis.cleanarchitecturelearnapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.presentation.MainViewModelFactory

@Module
class AppModule(val context: Context) {

    @Provides
    fun providerContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}