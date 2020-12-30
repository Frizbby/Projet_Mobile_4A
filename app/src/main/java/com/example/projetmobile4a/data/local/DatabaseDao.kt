package com.example.projetmobile4a.data.local

//import com.example.projetmobile4a.data.local.models.UserLocal
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projetmobile4a.domain.entity.User



@Dao
interface DatabaseDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Query("SELECT * FROM user_table WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): User?

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY uid ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE email LIKE :email AND password LIKE :password")
    fun findUserWithName(email: String, password: String): LiveData<List<User>>

}