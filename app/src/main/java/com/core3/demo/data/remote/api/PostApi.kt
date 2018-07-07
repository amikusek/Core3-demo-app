package com.core3.demo.data.remote.api

import com.core3.demo.data.remote.model.CommentRemote
import com.core3.demo.data.remote.model.PostRemote
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<PostRemote>>

    @GET("posts/{post_id}/comments")
    fun getComments(@Path("post_id") id: Int): Observable<List<CommentRemote>>
}
