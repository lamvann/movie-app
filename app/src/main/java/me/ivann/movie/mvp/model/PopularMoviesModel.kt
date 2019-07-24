package me.ivann.movie.mvp.model

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.domain.Entity
import me.ivann.movie.util.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PopularMoviesModel {

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val service: MovieApi
        get() = retrofit.create(MovieApi::class.java)

    fun getPopularMovies(): Observable<Entity.PopularMovies> =
        service.getPopularMovies(Constants.KEY_API, LANGUAGE, SORT_BY, ADULT, PAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    companion object {
        // Business Rules
        const val LANGUAGE = "en-US"
        const val SORT_BY = "popularity.desc"
        const val ADULT = "false"
        const val PAGE = 1
    }
}
