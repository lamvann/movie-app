package me.ivann.movie.util.extension

import io.reactivex.disposables.Disposable
import me.ivann.movie.util.AutoDisposable

infix fun Disposable.addTo(autoDisposable: AutoDisposable) = autoDisposable.add(this)