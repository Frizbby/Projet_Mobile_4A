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

   // suspend fun getUser(email: String): User? {
       // val userLocal = databaseDao.findByName(email)
       // return userLocal?.toEntity()

  //  }

    suspend fun addUser(user: User){
        databaseDao.addUser(user)
    }

    suspend fun findUserWithName(email: String, password: String) {
        databaseDao.findUserWithName(email,password)
    }

}