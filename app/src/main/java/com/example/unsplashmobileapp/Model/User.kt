package com.example.unsplashmobileapp.Model

import androidx.room.Embedded
import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class User(
    @SerialName("Links")
    @Embedded
    val userLinks: UserLinks,
    val username: String
)
