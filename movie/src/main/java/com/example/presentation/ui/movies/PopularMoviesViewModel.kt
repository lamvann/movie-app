package com.example.presentation.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.movies.GetPopularMoviesUseCase
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

    private val moviesLiveData = MutableLiveData<String>()

    val movieData: LiveData<String> = moviesLiveData

    fun getPopularMovies(autoDisposable: AutoDisposable) {
        popularMoviesUseCase().subscribe({ movies ->
            val stringBuilder = StringBuilder()
            movies.forEach {
                stringBuilder.append(TEXT.format(it.title, it.overview))
            }
                moviesLiveData.value = stringBuilder.toString()
        },
            {
                Log.e(TAG, it.message.toString())
            }
        ) addTo autoDisposable
    }

    companion object {
        const val TAG = "PopularMoviesViewModel"
    }
}