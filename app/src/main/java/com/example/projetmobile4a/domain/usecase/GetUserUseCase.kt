package com.example.projetmobile4a.domain.usecase

import com.example.projetmobile4a.data.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {
   /* suspend fun invoke(email : String) : User? {
        return userRepository.getUser(email)
    }*/
}