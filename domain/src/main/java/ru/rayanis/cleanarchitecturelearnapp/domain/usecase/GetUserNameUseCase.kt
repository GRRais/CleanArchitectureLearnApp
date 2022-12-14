package ru.rayanis.cleanarchitecturelearnapp.domain.usecase

import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {

        return userRepository.getName()
    }
}