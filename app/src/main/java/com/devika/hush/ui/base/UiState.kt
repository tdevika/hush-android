package com.devika.hush.ui.base

sealed class BaseState{
    object Loading : BaseState()
    data class Error(val message: String?) : BaseState()
}
sealed class UiState:BaseState() {
    data class Success(val value: Any) : UiState()
}

inline fun <reified T> Any.getList(): List<T>? {
    if (this is List<*>) {
        return filterIsInstance<T>()
    }
    return null
}
