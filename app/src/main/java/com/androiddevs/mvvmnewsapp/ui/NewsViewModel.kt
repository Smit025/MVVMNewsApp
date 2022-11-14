package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.db.models.NewsResponse
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.util.Resource

import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val breakingNewsPage = 1
    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val searchNewsPage = 1

    init {
        getBreakingNews("in")
    }

    private fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handlingBreakingNewsResponse(response))
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchForNews(searchQuery, searchNewsPage)
        searchNews.postValue(handlingSearchNewsResponse(response))
    }

    private fun handlingBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {

        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handlingSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {

        if (response.isSuccessful) {
            response.body()?.let {searchResponse ->
                return Resource.Success(searchResponse)
            }
        }
        return Resource.Error(response.message())
    }

}