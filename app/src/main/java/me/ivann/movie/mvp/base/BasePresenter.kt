package me.ivann.movie.mvp.base

interface BasePresenter<in T> {
    fun attach(view: T)
}
