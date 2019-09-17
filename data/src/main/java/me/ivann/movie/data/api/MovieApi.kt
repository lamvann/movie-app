package me.ivann.movie.data.api

import me.ivann.movie.data.api.response.dto.PopularMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") includeAdult: String,
        @Query("page") page: Int,
        @Query("with_genres") genre: String,
        @Query("primary_release_year") year: String
    ) : Response<PopularMoviesDto>

}