package com.stebakov.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stebakov.domain.entity.database.FavoritePhone

@Database(entities = [FavoritePhone::class], version = 1)
abstract class FavoritePhonesDatabase : RoomDatabase() {
    abstract fun favoritePhonesDao(): FavoritePhonesDao

    companion object {
        private var INSTANCE: FavoritePhonesDatabase? = null

        fun getInstance(context: Context): FavoritePhonesDatabase? {
            if (INSTANCE == null) {
                synchronized(FavoritePhonesDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoritePhonesDatabase::class.java, "favorite"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}