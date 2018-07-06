package com.core3.demo.viper.post

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter

class PostPresenter : BaseRxPresenter<PostContract.View, PostContract.Interactor, PostContract.Routing>(), ViperPresenter<PostContract.View> {

    override fun createRouting() = PostRouting()

    override fun createInteractor() = PostInteractor()
}
