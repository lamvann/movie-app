package me.ivann.movie.data.api

import me.ivann.movie.data.service.NetworkFailure
import retrofit2.Response

interface RestErrorHandler {

    fun <T> Response<T>.handleErrors(): Result<T> {
        val body: T? = body()

        return if (isSuccessful && body != null) {
            Result.success(body)
        } else {
            Result.failure(NetworkFailure(errorBody().toString()))
        }
    }
}