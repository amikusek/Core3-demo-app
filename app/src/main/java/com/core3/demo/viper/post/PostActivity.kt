package com.core3.demo.viper.post

import com.core3.demo.R
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity

class PostActivity : ViperAiPassiveActivity<PostContract.View>(), PostContract.View {

    override fun createPresenter() = PostPresenter()

    override fun getLayoutId() = R.layout.activity_post
}
