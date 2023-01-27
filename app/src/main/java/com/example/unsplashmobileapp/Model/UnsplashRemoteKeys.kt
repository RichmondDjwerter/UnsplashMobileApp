package com.example.unsplashmobileapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.unsplashmobileapp.Util.Constant.UNSPLASH_REMOTE_KEY_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEY_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPAge: Int?
)
