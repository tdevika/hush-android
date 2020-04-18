package com.devika.hush.utils.result

import androidx.lifecycle.MutableLiveData
import com.devika.hush.utils.result.Results.Success

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Results<out R> {

    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val exception: Exception) : Results<Nothing>()
    object Loading : Results<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * [Success.data] if [Results] is of type [Success]
 */
fun <T> Results<T>.successOr(fallback: T): T {
    return (this as? Success<T>)?.data ?: fallback
}

val <T> Results<T>.data: T?
    get() = (this as? Success)?.data

/**
 * Updates value of [liveData] if [Results] is of type [Success]
 */
inline fun <reified T> Results<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is Success) {
        liveData.value = data
    }
}
