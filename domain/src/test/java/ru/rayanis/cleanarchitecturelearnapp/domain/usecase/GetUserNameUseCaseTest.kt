package ru.rayanis.cleanarchitecturelearnapp.domain.usecase

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.models.UserName
import ru.rayanis.cleanarchitecturelearnapp.domain.repository.UserRepository

class TestRepository: UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): UserName {
        return UserName(firstName = "test first name", lastName = "test last name")
    }
}

class GetUserNameUseCaseTest {

    @Test
    fun test() {

        val testRepository = TestRepository()
        val useCase = GetUserNameUseCase(userRepository = testRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expected, actual)
    }
}