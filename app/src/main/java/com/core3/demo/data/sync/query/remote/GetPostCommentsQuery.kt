package com.core3.demo.data.sync.query.remote

import com.core3.demo.data.entity.Comment
import com.core3.demo.data.sync.ApiManager
import com.core3.demo.data.sync.query._base.RemoteQuery

class GetPostCommentsQuery(val id: Int) : RemoteQuery<List<Comment>> {

    override fun executeRemote(apiManager: ApiManager) = apiManager.getPostComments(id)
}
