package com.stebakov.data.cache

import com.stebakov.data.cache.database.FavoritePhonesDao
import com.stebakov.domain.entity.database.FavoritePhone

class Cache(private val favoritePhonesDao: FavoritePhonesDao) {

    suspend fun addFavoritePhone(favoritePhone: FavoritePhone){
        favoritePhonesDao.addFavoritePhone(favoritePhone)
    }

    suspend fun getFavoritePhones() = favoritePhonesDao.getAllFavoritePhones()

    suspend fun deleteFavoritePhone(favoritePhone: FavoritePhone){
        favoritePhonesDao.deleteFavoritePhone(favoritePhone)
    }
}