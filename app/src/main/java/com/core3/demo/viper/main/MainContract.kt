package com.core3.demo.viper.main

import android.app.Activity
import com.core3.demo.data.entity.Post

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import io.reactivex.Observable

interface MainContract {

    interface View : MvpView {
        val listItemClicksEvents: Observable<Post>
        fun setList(posts: List<Post>)
        fun showList()
        fun showLoading()
        fun showEmptyView()
        fun showError(throwable: Throwable)
    }

    interface Interactor : ViperRxInteractor {
        fun getPosts(): Observable<List<Post>>
    }

    interface Routing : ViperRxRouting<Activity> {
        fun showPostScreen(post: Post)
        fun logScreenViewEvent()
        fun logListItemClicksEvents(id: Int)
    }
}
