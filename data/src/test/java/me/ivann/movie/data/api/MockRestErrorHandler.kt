package me.ivann.movie.data.api

import retrofit2.Response

class MockRestErrorHandler : RestErrorHandler {

    fun <T> testResponse(response: Response<T>): Result<T> = response.handleErrors()
}