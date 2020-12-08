package com.example.projetmobile4a.domain.usecase

import com.example.projetmobile4a.data.repository.UserRepository
import com.example.projetmobile4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with valid email`() {

        runBlocking {
            val email = "wow@incroyable.com"
            val expectedUser = User("wow@incroyable.com")
            coEvery { userRepository.getUser(email) } returns expectedUser

            val result = classUnderTest.invoke(email)


            coVerify(exactly = 1) { userRepository.getUser(email) }
            
            assertEquals(result,expectedUser)

        }

    }
}
