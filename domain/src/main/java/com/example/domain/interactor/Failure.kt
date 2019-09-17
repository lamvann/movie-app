package com.example.domain.interactor

/**
 * @author Matt Rea
 *
 * Base class for Failure/Error handling across all features and layers
 */
sealed class Failure(message: String?, throwable: Throwable?) : Throwable(throwable?.message ?: message ?: "No message") {

    /*** Extend this class for data specific failures. */
    abstract class DataFailure(message: String? = null, throwable: Throwable? = null) : Failure(message, throwable)


    /*** Extend this class for feature specific failures. */
    abstract class FeatureFailure(message: String? = null, exception: Exception? = null) : Failure(message, exception)
}