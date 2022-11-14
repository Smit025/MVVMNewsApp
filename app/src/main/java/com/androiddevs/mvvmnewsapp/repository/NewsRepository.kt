package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.db.ArticleDao
import com.androiddevs.mvvmnewsapp.db.ArticleDataBase
import com.androiddevs.mvvmnewsapp.db.models.Article

class NewsRepository(val db: ArticleDataBase) {

    fun getAllArticles() = db.getArticleDao()

    suspend fun upsert(article: Article): Long =
        db.getArticleDao().upsert(article)

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)
}