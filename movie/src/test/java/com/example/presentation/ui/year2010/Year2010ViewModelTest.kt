package com.example.presentation.ui.year2010

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.entity.Movie
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.Year2010MoviesUseCase
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

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class Year2010ViewModelTest {

    lateinit var year2010ViewModel: Year2010ViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @Test
    fun `when viewmodel is created, the default UiModel is emitted`() {
        // when
        year2010ViewModel = Year2010ViewModel(mockk(), Year2010MoviesUseCase(mockk()))
        val default =
            Year2010UiModel.default.copy(onFetchButtonClicked = year2010ViewModel::fetchMovies)

        // then
        Assert.assertEquals(year2010ViewModel.uiModel, default)
    }

    @Test
    fun `given a successful network response, when fetchMovies is called, moviesText should be set and isLoading should be toggled`() {
        // given
        val movieTitle = "My Movie"
        val movieOverview = "My Movie Overview"
        val expectedText = "•Title: My Movie\nOverview: My Movie Overview\n\n"

        val useCase: Year2010MoviesUseCase = mockk()
        coEvery { useCase() } returns Result.success(listOf(Movie(movieTitle, movieOverview)))

        year2010ViewModel = Year2010ViewModel(mockk(), useCase)

        val liveDataValues: MutableList<Year2010UiModel> = mutableListOf()
        year2010ViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        year2010ViewModel.fetchMovies()

        // then
        Assert.assertTrue(liveDataValues[0].isLoading)
        Assert.assertEquals(liveDataValues[1].moviesText, expectedText)
        Assert.assertFalse(liveDataValues[1].isLoading)
    }

    @Test
    fun `given a failed network response, when fetchMovies is called, onError should be called`() {
        // given
        val useCase: Year2010MoviesUseCase = mockk()
        val failure = object : Failure.DataFailure("mock", Throwable()) {}

        coEvery { useCase() } returns Result.failure(failure)
        year2010ViewModel = spyk(Year2010ViewModel(mockk(), useCase))

        // when
        year2010ViewModel.fetchMovies()

        // then
        verify { year2010ViewModel.onError(failure) }
    }

    @Test
    fun `when onError is called, isLoading should be set to false and hasError should be set to true`() {
        // given
        val failure = object : Failure.DataFailure("mock", Throwable()) {}
        year2010ViewModel = Year2010ViewModel(mockk(), mockk())

        val liveDataValues: MutableList<Year2010UiModel> = mutableListOf()
        year2010ViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        year2010ViewModel.onError(failure)

        // then
        Assert.assertTrue(liveDataValues[0].hasError)
        Assert.assertFalse(liveDataValues[0].isLoading)
    }
}