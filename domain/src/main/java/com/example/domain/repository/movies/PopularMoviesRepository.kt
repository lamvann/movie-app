package com.example.domain.repository.movies

import com.example.domain.entity.Movie
import com.example.domain.repository.BaseRepository
import io.reactivex.Observable

interface PopularMoviesRepository : BaseRepository {

    //todo: cache movies
    val movies: List<Movie>

    suspend fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int,
        primaryReleaseYear: String = "",
        genre: String = ""
    ): Result<List<Movie>>

}