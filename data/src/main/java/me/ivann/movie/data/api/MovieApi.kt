package me.ivann.movie.data.api

import me.ivann.movie.data.api.response.dto.Dto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") includeAdult: String,
        @Query("page") page: Int
    ) : Dto.PopularMovies
}
