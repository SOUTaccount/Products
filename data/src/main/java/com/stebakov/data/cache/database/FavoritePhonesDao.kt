package com.stebakov.data.cache.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stebakov.domain.entity.database.FavoritePhone

interface FavoritePhonesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoritePhone(favoritePhone: FavoritePhone)

    @Query("SELECT * FROM favoritephone")
    suspend fun getAllFavoritePhones() : List<FavoritePhone>

    @Delete
    suspend fun deleteFavoritePhone(favoritePhone: FavoritePhone)

}