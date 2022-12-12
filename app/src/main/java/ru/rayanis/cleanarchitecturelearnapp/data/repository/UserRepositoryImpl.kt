package ru.rayanis.cleanarchitecturelearnapp.data.repository

import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository{

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return true
    }

    override fun getName(): UserName {
        return UserName(firstName = "Rais", lastName = "Garifzyanov")
    }
}