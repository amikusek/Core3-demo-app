package com.core3.demo.viper.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.core3.demo.Core3DemoApp
import com.core3.demo.R
import com.core3.demo.constants.POST_ARGS
import com.core3.demo.data.entity.Post
import com.core3.demo.viper.post.PostActivity

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting

class MainRouting : BaseRxRouting<Activity>(), MainContract.Routing {

    override fun showPostScreen(post: Post) {
        relatedContext?.let {
            it.startActivity(Intent(it, PostActivity::class.java).apply {
                putExtra(POST_ARGS, post)
            })
            it.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    override fun logScreenViewEvent() {
        relatedContext?.let {
            (it.application as Core3DemoApp).getFirebaseInstance().logEvent("screen_display", Bundle().apply {
                putString("name", relatedContext?.getString(R.string.posts_toolbar_title))
            })
        }
    }

    override fun logListItemClicksEvents(id: Int) {
        relatedContext?.let {
            (it.application as Core3DemoApp).getFirebaseInstance().logEvent("post_list_item_clicks", Bundle().apply {
                putInt("post_id", id)
            })
        }
    }
}
