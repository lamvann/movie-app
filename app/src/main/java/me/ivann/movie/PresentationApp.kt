package me.ivann.movie

import dagger.android.DaggerApplication
import me.ivann.movie.di.component.DaggerAppComponent

class PresentationApp : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent
        .builder()
        .application(this)
        .build()
}