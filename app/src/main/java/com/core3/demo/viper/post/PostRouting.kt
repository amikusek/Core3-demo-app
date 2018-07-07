package com.core3.demo.viper.post

import android.app.Activity
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.core3.demo.Core3DemoApp
import com.core3.demo.R

class PostRouting : BaseRxRouting<Activity>(), PostContract.Routing {

    override fun openEmailApp(email: String) {
        relatedContext?.let {
            startActivity(it,
                    Intent.createChooser(Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$email")
                    }, it.getString(R.string.app_chooser_title)), null)
        }
    }

    override fun closeScreen() {
        relatedContext?.finish()
    }

    override fun logScreenViewEvent() {
        relatedContext?.let {
            (it.application as Core3DemoApp).getFirebaseInstance().logEvent("screen_display", Bundle().apply {
                putString("name", relatedContext?.getString(R.string.post_toolbar_title))
            })
        }
    }
}
