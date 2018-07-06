package com.core3.demo.data.remote.api

import com.core3.demo.data.remote.model.PostRemote
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<PostRemote>>
}
