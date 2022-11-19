package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDao
import com.androiddevs.mvvmnewsapp.db.ArticleDataBase
import com.androiddevs.mvvmnewsapp.db.models.Article

class NewsRepository(val db: ArticleDataBase) {


    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchForNews(searchQuery:String,pageNumber:Int) = RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun upsert(article: Article): Long =
        db.getArticleDao().upsert(article)

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)
}