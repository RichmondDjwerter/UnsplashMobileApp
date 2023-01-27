package com.example.unsplashmobileapp.di

import android.content.Context
import androidx.room.Room
import com.example.unsplashmobileapp.Util.Constant.UNSPLASH_DATABASE
import com.example.unsplashmobileapp.data.local.UnsplashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context, UnsplashDatabase::class.java, UNSPLASH_DATABASE
        ).build()
    }
}