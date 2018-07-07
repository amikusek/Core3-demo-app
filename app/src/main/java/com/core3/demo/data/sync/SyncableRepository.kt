package com.core3.demo.data.sync

import com.core3.demo.data.sync.query._base.RemoteQuery
import com.core3.demo.extension.subscribeOnIo

class SyncableRepository {

    private val apiManager = ApiManager()

    fun <Entity> query(query: RemoteQuery<Entity>) =
            query.executeRemote(apiManager).subscribeOnIo()
}
