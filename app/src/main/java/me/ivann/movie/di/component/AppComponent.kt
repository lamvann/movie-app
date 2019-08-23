package me.ivann.movie.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.ivann.movie.util.PresentationApp
import me.ivann.movie.di.module.*
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        ServiceModule::class,
        RepositoryModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<PresentationApp> {
    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    /*
     * This is our custom Application class
     * */
    override fun inject(presentationApp: PresentationApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}