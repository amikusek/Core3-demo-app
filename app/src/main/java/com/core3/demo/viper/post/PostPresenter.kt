package com.core3.demo.viper.post

import com.core3.demo.data.entity.Comment
import com.core3.demo.data.entity.User
import com.core3.demo.extension.observeOnMain
import com.core3.demo.extension.retrySubscribe
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

class PostPresenter : BaseRxPresenter<PostContract.View, PostContract.Interactor, PostContract.Routing>(), ViperPresenter<PostContract.View> {

    private val onAttachViewEvents = PublishSubject.create<Any>()

    override fun attachView(attachingView: PostContract.View?) {
        super.attachView(attachingView)

        addSubscription(
                onAttachViewEvents
                        .doOnNext { view?.showLoading() }
                        .doOnNext { routing.logScreenViewEvent() }
                        .filter { view != null }
                        .map { view?.post }
                        .flatMap {
                            Observable.zip<User, List<Comment>, Pair<User, List<Comment>>>(
                                    interactor.getUser(it.userId),
                                    interactor.getComments(it.id),
                                    BiFunction { t1, t2 -> Pair(t1, t2) })
                        }
                        .observeOnMain()
                        .retrySubscribe(
                                onNext = { (user, comments) ->
                                    view?.render(user, comments)
                                    view?.showList()
                                },
                                onError = {
                                    view?.showEmptyView()
                                    view?.showError(it)
                                }
                        ))
        addSubscription(
                view
                        ?.backButtonClicks
                        ?.retrySubscribe(
                                onNext = { routing.closeScreen() }
                        ))
        addSubscription(
                view
                        ?.emailClickEvents
                        ?.retrySubscribe(
                                onNext = { routing.openEmailApp(it.email) }
                        ))

        onAttachViewEvents.onNext(Unit)
    }

    override fun createRouting() = PostRouting()

    override fun createInteractor() = PostInteractor()
}
