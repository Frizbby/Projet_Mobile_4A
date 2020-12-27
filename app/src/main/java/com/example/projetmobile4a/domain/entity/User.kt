package com.example.projetmobile4a.domain.entity

import androidx.room.Entity

@Entity(tableName = "user_table")
data class User (
    val email: String
)