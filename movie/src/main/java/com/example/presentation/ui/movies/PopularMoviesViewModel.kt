package com.example.presentation.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import me.ivann.movie.util.AutoDisposable
import me.ivann.movie.util.Constants.TEXT
import me.ivann.movie.util.extension.addTo
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    init {
        Log.e(TAG, "ViewModel Created!")
    }

    val fetchMovieData = liveData(Dispatchers.IO) {
        val stringBuilder = StringBuilder()
        popularMoviesUseCase().forEach { stringBuilder.append(TEXT.format(it.title, it.overview)) }
        emit(stringBuilder.toString())
    }

    val popularMovies: LiveData<String> = fetchMovieData

    companion object {
        const val TAG = "PopularMoviesViewModel"
    }
}
