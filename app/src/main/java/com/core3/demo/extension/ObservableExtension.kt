package com.core3.demo.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.OnErrorNotImplementedException
import io.reactivex.schedulers.Schedulers

private val onNextStub: (Any) -> Unit = {}
private val onErrorStub: (Throwable) -> Unit = { throw OnErrorNotImplementedException(it) }
private val onCompleteStub: () -> Unit = {}

fun <T> Observable<T>.observeOnMain(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.observeOnIo(): Observable<T> {
    return this.observeOn(Schedulers.io())
}

fun <T> Observable<T>.observeOnComputation(): Observable<T> {
    return this.observeOn(Schedulers.computation())
}

fun <T : Any> Observable<T>.retrySubscribe(onNext: (T) -> Unit = onNextStub,
                                           onError: (Throwable) -> Unit = onErrorStub,
                                           onComplete: () -> Unit = onCompleteStub) =
        this.doOnNext(onNext)
                .doOnComplete(onComplete)
                .doOnError(onError)
                .retry()
                .subscribe()!!
