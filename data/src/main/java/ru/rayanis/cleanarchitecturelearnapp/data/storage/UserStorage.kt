package ru.rayanis.cleanarchitecturelearnapp.data.storage

import ru.rayanis.cleanarchitecturelearnapp.data.storage.models.User

interface UserStorage {
    fun save(saveParam: User): Boolean
    fun get(): User
}