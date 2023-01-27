package com.example.unsplashmobileapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unsplashmobileapp.Model.UnsplashRemoteKeys

@Dao
interface UnsplashRemoteKeyDao {
    @Query("SELECT * FROM unsplash_remote_key_table WHERE id =:id")
    suspend fun getRemoteKey(id: String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("DELETE FROM unsplash_remote_key_table")
    suspend fun deleteAllRemoteKeys()
}