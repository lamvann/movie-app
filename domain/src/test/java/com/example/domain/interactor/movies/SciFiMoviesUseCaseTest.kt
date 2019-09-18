package com.example.domain.interactor.movies

import com.example.domain.entity.Movie
import com.example.domain.repository.movies.PopularMoviesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SciFiMoviesUseCaseTest {

    lateinit var sciFiMoviesUseCase: SciFiMoviesUseCase
    lateinit var popularMoviesRepository: PopularMoviesRepository

    @Before
    fun init() {
        popularMoviesRepository = mockk()
        sciFiMoviesUseCase = SciFiMoviesUseCase(popularMoviesRepository)
    }

    @Test
    fun `given the repository returns a successful Result, run() should return a successful result`() = runBlockingTest {
        val movieList = listOf(
            Movie("title1", "overview1"),
            Movie("title2", "overview2")
        )

        val response = Result.success(movieList)

        //given
        coEvery { popularMoviesRepository.get(any(), any(), any(), any(), any(), any()) } returns response

        //when
        val result: Result<List<Movie>> = sciFiMoviesUseCase.run()

        //then
        coVerify(exactly = 1) {
            popularMoviesRepository.get(
                "en-US",
                "popularity.desc",
                "false",
                1,
                "2010",
                ""
            )
        }

        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow() == movieList)
    }

    @Test
    fun `given the repository returns a failed Result, run() should return a failed result`() = runBlockingTest {
        val error = IllegalStateException("error")
        val response: Result<List<Movie>> = Result.failure(error)

        //given
        coEvery { popularMoviesRepository.get(any(), any(), any(), any(), any(), any()) } returns response

        //when
        val result: Result<List<Movie>> = sciFiMoviesUseCase.run()

        //then
        coVerify(exactly = 1) {
            popularMoviesRepository.get(
                "en-US",
                "popularity.desc",
                "false",
                1,
                "2010",
                ""
            )
        }

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() == error)
    }
}