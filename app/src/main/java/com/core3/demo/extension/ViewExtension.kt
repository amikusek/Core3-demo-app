package com.core3.demo.extension

import android.view.View
import com.jakewharton.rxbinding2.view.RxView

fun View.throttleClicks() = RxView.clicks(this)
        .throttleFirst(200, java.util.concurrent.TimeUnit.MILLISECONDS)

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}
