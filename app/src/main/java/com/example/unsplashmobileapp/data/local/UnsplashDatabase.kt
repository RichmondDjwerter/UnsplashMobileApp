package com.example.unsplashmobileapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unsplashmobileapp.Model.UnsplashImage
import com.example.unsplashmobileapp.Model.UnsplashRemoteKeys
import com.example.unsplashmobileapp.data.local.dao.UnsplashImageDao
import com.example.unsplashmobileapp.data.local.dao.UnsplashRemoteKeyDao

@Database(
    version = 1,
    entities = [UnsplashImage::class, UnsplashRemoteKeys::class],
    exportSchema = false
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeyDao(): UnsplashRemoteKeyDao
}