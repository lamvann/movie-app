package me.ivann.movie.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object ApiModule {
    @JvmStatic
    @Provides
    @Reusable
    fun providesShipsApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

    @JvmStatic
    @Provides
    @Reusable
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}