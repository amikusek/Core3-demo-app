package com.core3.demo.data.sync.query._base

import com.core3.demo.data.sync.ApiManager
import io.reactivex.Observable

interface RemoteQuery<Entity> {

    fun executeRemote(apiManager: ApiManager): Observable<Entity>
}
