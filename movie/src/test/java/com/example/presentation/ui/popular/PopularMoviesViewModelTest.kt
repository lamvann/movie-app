package com.example.presentation.ui.popular

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.entity.Movie
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import com.example.presentation.ui.util.collectNewValues
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PopularMoviesViewModelTest {

    lateinit var popularMoviesViewModel: PopularMoviesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun init() {
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @Test
    fun `when viewmodel is created, the default UiModel is emitted`() {
        // when
        popularMoviesViewModel = PopularMoviesViewModel(mockk(), GetPopularMoviesUseCase(mockk()))
        val default = PopularMoviesUiModel.default.copy(onFetchButtonClicked = popularMoviesViewModel::fetchMovies)

        // then
        Assert.assertEquals(popularMoviesViewModel.uiModel, default)
    }

    @Test
    fun `given a successful network response, when fetchMovies is called, moviesText should be set and isLoading should be toggled`() {
        // given
        val movieTitle = "My Movie"
        val movieOverview = "My Movie Overview"
        val expectedText = "•Title: My Movie\nOverview: My Movie Overview\n\n"

        val useCase: GetPopularMoviesUseCase = mockk()
        coEvery { useCase() } returns Result.success(listOf(Movie(movieTitle, movieOverview)))

        popularMoviesViewModel = PopularMoviesViewModel(mockk(), useCase)

        val liveDataValues: MutableList<PopularMoviesUiModel> = mutableListOf()
        popularMoviesViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        popularMoviesViewModel.fetchMovies()

        // then
        Assert.assertTrue(liveDataValues[0].isLoading)
        Assert.assertEquals(liveDataValues[1].moviesText, expectedText)
        Assert.assertFalse(liveDataValues[1].isLoading)
    }

    @Test
    fun `given a failed network response, when fetchMovies is called, onError should be called`() {
        // given
        val useCase: GetPopularMoviesUseCase = mockk()
        val failure = object : Failure.DataFailure("mock", Throwable()) {}

        coEvery { useCase() } returns Result.failure(failure)
        popularMoviesViewModel = spyk(PopularMoviesViewModel(mockk(), useCase))

        // when
        popularMoviesViewModel.fetchMovies()

        // then
        verify { popularMoviesViewModel.onError(failure) }
    }

    @Test
    fun `when onError is called, isLoading should be set to false and hasError should be set to true`() {
        // given
        val failure = object : Failure.DataFailure("mock", Throwable()) {}
        popularMoviesViewModel = PopularMoviesViewModel(mockk(), mockk())

        val liveDataValues: MutableList<PopularMoviesUiModel> = mutableListOf()
        popularMoviesViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        popularMoviesViewModel.onError(failure)

        // then
        Assert.assertTrue(liveDataValues[0].hasError)
        Assert.assertFalse(liveDataValues[0].isLoading)
    }
}