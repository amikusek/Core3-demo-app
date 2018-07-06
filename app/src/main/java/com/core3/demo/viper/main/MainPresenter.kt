package com.core3.demo.viper.main

import com.core3.demo.extension.observeOnIo
import com.core3.demo.extension.observeOnMain
import com.core3.demo.extension.retrySubscribe
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import io.reactivex.subjects.PublishSubject

class MainPresenter : BaseRxPresenter<MainContract.View, MainContract.Interactor, MainContract.Routing>(), ViperPresenter<MainContract.View> {

    private val onAttachViewEvents = PublishSubject.create<Any>()

    override fun attachView(attachingView: MainContract.View?) {
        super.attachView(attachingView)

        addSubscription(
                onAttachViewEvents
                        .doOnNext { view?.showLoading() }
                        .observeOnIo()
                        .flatMap { interactor.getPosts() }
                        .observeOnMain()
                        .retrySubscribe(
                                onNext = {
                                    view?.setList(it)
                                    view?.showList()
                                },
                                onError = {
                                    view?.showEmptyView()
                                    view?.showError(it)
                                }
                        ))

        onAttachViewEvents.onNext(Unit)
    }

    override fun createRouting() = MainRouting()

    override fun createInteractor() = MainInteractor()
}
