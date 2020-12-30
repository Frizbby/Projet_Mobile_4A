package com.example.projetmobile4a.data.repository

import androidx.lifecycle.LiveData
import com.example.projetmobile4a.data.local.DatabaseDao
//import com.example.projetmobile4a.data.local.models.toData
//import com.example.projetmobile4a.data.local.models.toEntity
import com.example.projetmobile4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {

    val readAllData: LiveData<List<User>> = databaseDao.readAllData()

    suspend fun createUser(user : User){
        //databaseDao.insert(user.toData())
    }

   /* suspend fun getUser(email: String): User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.

    }*/

    suspend fun addUser(user: User){
        databaseDao.addUser(user)
    }
    suspend fun findUser(email: String): User?{
        val user = databaseDao.findByName(email)
        return user
    }
    suspend fun findUserWithName(email: String, password: String): User? {
        val user = databaseDao.findUserWithName(email,password)
        return user
    }

}