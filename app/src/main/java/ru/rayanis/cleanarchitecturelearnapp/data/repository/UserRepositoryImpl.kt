package ru.rayanis.cleanarchitecturelearnapp.data.repository

import ru.rayanis.cleanarchitecturelearnapp.data.storage.models.User
import ru.rayanis.cleanarchitecturelearnapp.data.storage.UserStorage
import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository{

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        val userName = UserName(firstName = user.firstName, lastName = user.lastName)

        return userName
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}