package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.NewsResponse
import com.androiddevs.mvvmnewsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String = "in",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ):Response<NewsResponse>

}