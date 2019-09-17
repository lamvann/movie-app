package me.ivann.movie.data.api.mapper

import com.example.domain.entity.Movie

/**
 * Extension class to map album dto to album entity
 */
fun Movie.map(): Movie = Movie(
    title = title,
    overview = overview
)

//todo - remove this file