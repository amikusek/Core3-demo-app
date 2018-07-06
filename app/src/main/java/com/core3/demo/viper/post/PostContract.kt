package com.core3.demo.viper.post

import android.app.Activity

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting

interface PostContract {

    interface View : MvpView

    interface Interactor : ViperRxInteractor

    interface Routing : ViperRxRouting<Activity>
}
