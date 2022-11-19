package com.androiddevs.mvvmnewsapp.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}


public fun shortSnackBar(view: View,msg:String) = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
public fun longSnackBar(view: View,msg:String) = Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()