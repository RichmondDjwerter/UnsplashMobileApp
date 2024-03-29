package com.example.unsplashmobileapp.data.remote

import com.example.unsplashmobileapp.Model.UnsplashImage
import com.example.unsplashmobileapp.Util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UnsplashApi {
    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<UnsplashImage>
}