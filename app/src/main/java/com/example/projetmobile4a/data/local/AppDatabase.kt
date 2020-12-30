package com.example.projetmobile4a.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.example.projetmobile4a.data.local.models.UserLocal
import com.example.projetmobile4a.domain.entity.User

@Database(entities = arrayOf(
    User::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataBaseDao(): DatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}