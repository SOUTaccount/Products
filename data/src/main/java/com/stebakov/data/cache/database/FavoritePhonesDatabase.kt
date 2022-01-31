package com.stebakov.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stebakov.domain.entity.database.FavoritePhone

@Database(entities = [FavoritePhone::class], version = 1)
abstract class FavoritePhonesDatabase: RoomDatabase() {
    abstract val favoritePhonesDao: FavoritePhonesDao
}