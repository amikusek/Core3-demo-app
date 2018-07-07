package com.core3.demo.data.remote.api

import com.core3.demo.data.remote.model.UserRemote
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users/{user_id}/")
    fun getUser(@Path("user_id") id: Int): Observable<UserRemote>
}
