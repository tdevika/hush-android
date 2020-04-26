package com.devika.hush.data.domain

sealed class Result<out T> {

    object Loading : Result<Nothing>()

    data class Success<out T>(val value: T) : Result<T>()

    data class Error(val exception: Exception) : Result<Nothing>()
}

inline fun <T> Result<T>.onLoading(action: () -> Unit): Result<T> {
    if (this is Result.Loading) action()
    return this
}

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(this.value)
    return this
}

inline fun <T> Result<T>.onError(action: (Exception) -> Unit): Result<T> {
    if (this is Result.Error) action(this.exception)
    return this
}
