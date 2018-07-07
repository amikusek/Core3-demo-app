package com.core3.demo

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics

class Core3DemoApp : Application() {

    private var firebaseInstance: FirebaseAnalytics? = null

    fun getFirebaseInstance(): FirebaseAnalytics {
        if (firebaseInstance == null)
            firebaseInstance = FirebaseAnalytics.getInstance(this)
        return firebaseInstance!!
    }
}
