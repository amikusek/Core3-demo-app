package com.core3.demo.data.sync.query.remote

import com.core3.demo.data.entity.Post
import com.core3.demo.data.sync.ApiManager
import com.core3.demo.data.sync.query._base.RemoteQuery

class GetPostsQuery : RemoteQuery<List<Post>> {

    override fun executeRemote(apiManager: ApiManager) = apiManager.getPosts()
}
