package ru.rayanis.cleanarchitecturelearnapp.domain.usecase

import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}