package me.ivann.movie.data.api

import me.ivann.movie.data.service.NetworkFailure
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RestErrorHandlerTest {

    lateinit var restErrorHandler: MockRestErrorHandler

    @Before
    fun before() {
        restErrorHandler = MockRestErrorHandler()
    }

    @Test
    fun `given a successful, non-null network response, the error handler should a successful Result`() {
        //given
        val response = Response.success("content")

        //when
        val result = restErrorHandler.testResponse(response)

        //then
        Assert.assertTrue(result.isSuccess)
        Assert.assertTrue(result.getOrThrow() == "content")
    }

    @Test
    fun `given a successful, null network response, the error handler should a failed Result`() {
        //given
        val response = Response.success(null)

        //when
        val result = restErrorHandler.testResponse(response)

        //then
        Assert.assertTrue(result.isFailure)
        Assert.assertTrue(result.exceptionOrNull() is NetworkFailure)
        Assert.assertTrue(result.exceptionOrNull()?.message == "null")
    }

    @Test
    fun `given a failed, non-null network response, the error handler should a failed Result`() {
        val body =  ResponseBody.create(null, "content")

        //given
        val response = Response.error<String>(500, body)

        //when
        val result = restErrorHandler.testResponse(response)

        //then
        Assert.assertTrue(result.isFailure)
        Assert.assertTrue(result.exceptionOrNull() is NetworkFailure)
        Assert.assertTrue(result.exceptionOrNull()?.message == body.toString())
    }
}