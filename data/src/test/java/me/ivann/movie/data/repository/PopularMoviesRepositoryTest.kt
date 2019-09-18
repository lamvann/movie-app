package me.ivann.movie.data.repository

import com.example.domain.entity.Movie
import com.example.domain.repository.movies.PopularMoviesRepository
import com.example.domain.service.PopularMoviesService
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import me.ivann.movie.data.respository.PopularMoviesRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PopularMoviesRepositoryTest {

    lateinit var service: PopularMoviesService
    lateinit var repository: PopularMoviesRepository

    @Before
    fun before() {
        service = mockk()
        repository = PopularMoviesRepositoryImpl(service)
    }

    @Test
    fun `given a successful network response, get function should return a successful Result Movie List`() = runBlockingTest {
        val language = "en-US"
        val sortBy = "popularity.desc"
        val adult = "false"
        val page = 1
        val genre = "454"
        val year = "2010"

        val movieList = listOf(
            Movie("title1", "overview1"),
            Movie("title2", "overview2")
        )

        val response = Result.success(movieList)

        //given
        coEvery { service.getPopularMovies(any(), any(), any(), any(), any(), any()) } returns response

        //when
        val result = repository.get(language, sortBy, adult, page, year, genre)

        //then
        coVerify(exactly = 1) { service.getPopularMovies(language, sortBy, adult, page, genre, year) }

        Assert.assertTrue(result.isSuccess)
        Assert.assertTrue(result.getOrThrow() == movieList)
    }

    @Test
    fun `given a failed network response, get function should return a failure Result`() = runBlockingTest {
        val language = "en-US"
        val sortBy = "popularity.desc"
        val adult = "false"
        val page = 1
        val genre = "454"
        val year = "2010"

        val error = IllegalStateException("message")
        val response = Result.failure<List<Movie>>(error)

        //given
        coEvery { service.getPopularMovies(any(), any(), any(), any(), any(), any()) } returns response

        //when
        val result = repository.get(language, sortBy, adult, page, year, genre)

        //then
        coVerify(exactly = 1) { service.getPopularMovies(language, sortBy, adult, page, genre, year) }

        Assert.assertTrue(result.isFailure)
        Assert.assertTrue(result.exceptionOrNull() == error)
    }
}