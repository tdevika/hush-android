package com.devika.hush.ui.base

sealed class UiState {
    object Loading : UiState()
    data class Success(val value: Any) : UiState()
    data class Error(val message: String?) : UiState()
}

inline fun <reified T> Any.getList(): List<T>? {
    if (this is List<*>) {
        return filterIsInstance<T>()
    }
    return null
}
