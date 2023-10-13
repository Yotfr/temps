package ru.yotfr.temps.domain.model

/**
 * [Error] state can contain cached data
 */
sealed class DataState<out T: Any> {
    class Success<out T: Any>(val data: T) : DataState<T>()
    class Error<T: Any>(
        val cachedData: T?,
        val message: String?
    ) : DataState<T>()
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
    executable: suspend (
        cachedData: T?,
        message: String?
    ) -> Unit
): DataState<T> = apply {
    if (this is DataState.Error<T>) {
        executable(
            cachedData,
            message
        )
    }
}

suspend fun <T : Any> DataState<T>.onLoading(
    executable: suspend () -> Unit
): DataState<T> = apply {
    if (this is DataState.Loading<T>) {
        executable()
    }
}