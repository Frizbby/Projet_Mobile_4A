package com.example.projetmobile4a.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val email: String,
    val password: String
)