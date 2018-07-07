package com.core3.demo.data.sync.query.remote

import com.core3.demo.data.entity.User
import com.core3.demo.data.sync.ApiManager
import com.core3.demo.data.sync.query._base.RemoteQuery

class GetUserQuery(val id: Int) : RemoteQuery<User> {

    override fun executeRemote(apiManager: ApiManager) = apiManager.getUser(id)
}
