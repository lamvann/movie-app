package com.example.presentation.ui.sci_fi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.entity.Movie
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.SciFiMoviesUseCase
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
class SciFiMoviesViewModelTest {

    lateinit var sciFiMoviesViewModel: SciFiMoviesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @Test
    fun `when viewmodel is created, the default UiModel is emitted`() {
        // when
        sciFiMoviesViewModel = SciFiMoviesViewModel(mockk(), SciFiMoviesUseCase(mockk()))
        val default = SciFiMoviesUiModel.default.copy(onFetchButtonClicked = sciFiMoviesViewModel::fetchMovies)

        // then
        Assert.assertEquals(sciFiMoviesViewModel.uiModel, default)
    }

    @Test
    fun `given a successful network response, when fetchMovies is called, moviesText should be set and isLoading should be toggled`() {
        // given
        val movieTitle = "My Movie"
        val movieOverview = "My Movie Overview"
        val expectedText = "•Title: My Movie\nOverview: My Movie Overview\n\n"

        val useCase: SciFiMoviesUseCase = mockk()
        coEvery { useCase() } returns Result.success(listOf(Movie(movieTitle, movieOverview)))

        sciFiMoviesViewModel = SciFiMoviesViewModel(mockk(), useCase)

        val liveDataValues: MutableList<SciFiMoviesUiModel> = mutableListOf()
        sciFiMoviesViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        sciFiMoviesViewModel.fetchMovies()

        // then
        Assert.assertTrue(liveDataValues[0].isLoading)
        Assert.assertEquals(liveDataValues[1].moviesText, expectedText)
        Assert.assertFalse(liveDataValues[1].isLoading)
    }

    @Test
    fun `given a failed network response, when fetchMovies is called, onError should be called`() {
        // given
        val useCase: SciFiMoviesUseCase = mockk()
        val failure = object : Failure.DataFailure("mock", Throwable()) {}

        coEvery { useCase() } returns Result.failure(failure)
        sciFiMoviesViewModel = spyk(SciFiMoviesViewModel(mockk(), useCase))

        // when
        sciFiMoviesViewModel.fetchMovies()

        // then
        verify { sciFiMoviesViewModel.onError(failure) }
    }

    @Test
    fun `when onError is called, isLoading should be set to false and hasError should be set to true`() {
        // given
        val failure = object : Failure.DataFailure("mock", Throwable()) {}
        sciFiMoviesViewModel = SciFiMoviesViewModel(mockk(), mockk())

        val liveDataValues: MutableList<SciFiMoviesUiModel> = mutableListOf()
        sciFiMoviesViewModel.uiModelLiveData.collectNewValues(liveDataValues)

        // when
        sciFiMoviesViewModel.onError(failure)

        // then
        Assert.assertTrue(liveDataValues[0].hasError)
        Assert.assertFalse(liveDataValues[0].isLoading)
    }

}