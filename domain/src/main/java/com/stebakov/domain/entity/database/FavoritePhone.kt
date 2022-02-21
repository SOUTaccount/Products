package com.stebakov.domain.entity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritePhone(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val price: Int?,
    val picture: String,
    var isFavorites: Boolean
)