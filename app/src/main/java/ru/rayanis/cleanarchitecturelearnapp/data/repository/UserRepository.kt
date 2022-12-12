package ru.rayanis.cleanarchitecturelearnapp.data.repository

import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName

class UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean {
        return true
    }

    fun getName(): UserName {
        return UserName(firstName = "Rais", lastName = "Garifzyanov")
    }
}