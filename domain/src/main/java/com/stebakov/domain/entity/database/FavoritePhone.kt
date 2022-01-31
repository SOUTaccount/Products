package com.stebakov.domain.entity.database

import androidx.room.Entity

@Entity
data class FavoritePhone(
    val id: Int,
    val name: String,
    val price: Int?,
    val picture: String,
    var isFavorites: Boolean
)