package me.ivann.movie

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import me.ivann.movie.di.component.DaggerAppComponent

class PresentationApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<PresentationApp> =
        DaggerAppComponent.builder().create(this)
}
