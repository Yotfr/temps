package ru.yotfr.temps.domain.model

sealed class DataState<out T: Any> {
    class Success<out T: Any>(val data: T) : DataState<T>()
    class Error<T: Any>(val message: String?) : DataState<T>()
    class Loading<T: Any> : DataState<T>()
}

suspend fun <T : Any> DataState<T>.onSuccess(
    executable: suspend (T) -> Unit
): DataState<T> = apply {
    if (this is DataState.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> DataState<T>.onError(
    executable: suspend (message: String?) -> Unit
): DataState<T> = apply {
    if (this is DataState.Error<T>) {
        executable(message)
    }
}

suspend fun <T : Any> DataState<T>.onLoading(
    executable: suspend () -> Unit
): DataState<T> = apply {
    if (this is DataState.Loading<T>) {
        executable()
    }
}
