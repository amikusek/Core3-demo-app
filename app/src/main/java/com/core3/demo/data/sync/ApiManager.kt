package com.core3.demo.data.sync

import com.core3.demo.data.remote.RetrofitFactory
import com.core3.demo.data.remote.api.PostApi
import com.core3.demo.data.remote.mapper.CommentMapper
import com.core3.demo.data.remote.mapper.PostMapper

class ApiManager {

    private val postsMapper = PostMapper()
    private val commentMapper = CommentMapper()

    fun getPosts() = getApi(PostApi::class.java)
            .getPosts()
            .map { it.mapNotNull { postsMapper.mapOrNull(it) } }

    fun getPostComments(postId: Int) = getApi(PostApi::class.java)
            .getComments(postId)
            .map { it.mapNotNull { commentMapper.mapOrNull(it) } }

    private fun <T> getApi(clazz: Class<T>) = RetrofitFactory
            .createWithoutAuthorization(clazz)
}
