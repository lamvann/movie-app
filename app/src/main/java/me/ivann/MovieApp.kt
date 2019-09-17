package me.ivann

import android.app.Application
import com.example.domain.di.domainModule
import com.example.presentation.ui.di.movieModule
import me.ivann.movie.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@MovieApp)
            modules(listOf(domainModule, dataModule, movieModule))
        }
    }
}
