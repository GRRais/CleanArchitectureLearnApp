package ru.rayanis.cleanarchitecturelearnapp.di

import dagger.Module
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase

@Module
class DomainModule {

    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase {
        return  GetUserNameUseCase(userRepository = userRepository)
    }

    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return  SaveUserNameUseCase(userRepository = userRepository)
    }
}