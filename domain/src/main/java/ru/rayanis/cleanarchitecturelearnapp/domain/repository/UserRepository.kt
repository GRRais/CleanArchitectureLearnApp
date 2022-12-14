package ru.rayanis.cleanarchitecturelearnapp.domain.repository

import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}