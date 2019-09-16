package me.ivann.movie.data.api.mapper

import com.example.domain.Entity
import me.ivann.movie.data.api.response.dto.Dto

/**
 * Extension class to map album dto to album entity
 */
fun Dto.Movie.map(): Entity.Movie =
    Entity.Movie(
        title = title,
        overview = overview
    )