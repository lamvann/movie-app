package com.example.domain.interactor

import android.support.annotation.WorkerThread
//import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [BaseUseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
interface BaseUseCase<out Type> where Type : Any {

    @WorkerThread
    suspend fun run(): Result<Type>

    suspend operator fun invoke(): Result<Type> {
        return withContext(Dispatchers.IO) {
            kotlin.runCatching {
                run().getOrThrow()
            }.onFailure(::logError)
        }
    }
}
class UncaughtUseCaseError(throwable: Throwable) : Failure.DataFailure(throwable = throwable)
