package com.core3.demo.viper.main

import com.core3.demo.R
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter

class MainActivity : ViperAiPassiveActivity<MainContract.View>(), MainContract.View {

    override fun createPresenter() = MainPresenter()

    override fun getLayoutId() = R.layout.activity_main
}
