package com.androiddevs.mvvmnewsapp.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {


    class Success<T>(data: T) : Resource<T>() {

    }

    class Error<T>(message: String? = null, data: T? = null) : Resource<T>(data, message) {

    }

    class Loading<T>(data: T) : Resource<T>() {

    }

}