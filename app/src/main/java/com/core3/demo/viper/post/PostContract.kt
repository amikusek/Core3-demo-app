package com.core3.demo.viper.post

import android.app.Activity
import com.core3.demo.data.entity.Comment
import com.core3.demo.data.entity.Post
import com.core3.demo.data.entity.User

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import io.reactivex.Observable

interface PostContract {

    interface View : MvpView {
        val post: Post?
        fun render(user: User, comments: List<Comment>)
        fun showList()
        fun showLoading()
        fun showEmptyView()
        fun showError(throwable: Throwable)
    }

    interface Interactor : ViperRxInteractor {
        fun getUser(id: Int): Observable<User>
        fun getComments(id: Int): Observable<List<Comment>>
    }

    interface Routing : ViperRxRouting<Activity>
}
