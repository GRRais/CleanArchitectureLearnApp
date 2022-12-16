package ru.rayanis.cleanarchitecturelearnapp.di

import android.content.Context
import dagger.Module
import ru.rayanis.cleanarchitecturelearnapp.data.repository.UserRepositoryImpl
import ru.rayanis.cleanarchitecturelearnapp.data.storage.UserStorage
import ru.rayanis.cleanarchitecturelearnapp.data.storage.sharedprefs.SharedPrefUserStorage
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository

@Module
class DataModule {

    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}