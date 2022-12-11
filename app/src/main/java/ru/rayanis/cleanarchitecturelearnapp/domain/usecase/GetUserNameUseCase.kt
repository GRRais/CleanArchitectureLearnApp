package ru.rayanis.cleanarchitecturelearnapp.domain.usecase

import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Rais", lastName = "Garifzyanov")
    }
}