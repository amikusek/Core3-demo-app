package com.core3.demo.data.sync

import com.core3.demo.data.sync.query._base.RemoteQuery

class SyncableRepository {

    private val apiManager = ApiManager()

    fun <Entity> query(query: RemoteQuery<Entity>) = query.executeRemote(apiManager)
}
