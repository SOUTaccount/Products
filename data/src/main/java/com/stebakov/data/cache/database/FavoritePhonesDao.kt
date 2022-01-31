package com.stebakov.data.cache.database

import androidx.room.*
import com.stebakov.domain.entity.database.FavoritePhone

@Dao
interface FavoritePhonesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoritePhone(favoritePhone: FavoritePhone)

    @Query("SELECT * FROM favoritephone")
    suspend fun getAllFavoritePhones() : List<FavoritePhone>

    @Delete
    suspend fun deleteFavoritePhone(favoritePhone: FavoritePhone)

}