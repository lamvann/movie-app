package me.ivann.movie.mvp.presenter

import android.util.Log
import me.ivann.movie.mvp.contract.PopularMoviesContract
import me.ivann.movie.mvp.model.PopularMoviesModel
import me.ivann.movie.util.AutoDisposable
import me.ivann.movie.util.Constants.TEXT
import me.ivann.movie.util.extension.addTo

class PopularMoviesPresenter(
    private val model: PopularMoviesModel
) : PopularMoviesContract.Presenter {

    private lateinit var view: PopularMoviesContract.View

    override fun attach(view: PopularMoviesContract.View) {
        this.view = view
    }

    override fun getPopularMovies(autoDisposable: AutoDisposable) {
        model.getPopularMovies().subscribe({ movies ->
                val stringBuilder = StringBuilder()
                movies.results.forEach {
                    stringBuilder.append(TEXT.format(it.title, it.overview, it.voteAverage, it.releaseDate))
                }
                view.updateText(stringBuilder.toString())
            },
            {
                Log.e(TAG, it.message.toString())
            }
        ) addTo autoDisposable
    }

    companion object {
        const val TAG = "Presenter"
    }
}
