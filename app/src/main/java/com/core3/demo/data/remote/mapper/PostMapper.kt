package com.core3.demo.data.remote.mapper

import com.core3.demo.data.entity.Post
import com.core3.demo.data.remote.mapper._base.BaseMapper
import com.core3.demo.data.remote.model.PostRemote

class PostMapper : BaseMapper<PostRemote, Post> {

    override fun mapOrNull(model: PostRemote): Post? {
        return if (model.id == null || model.userId == null)
            null
        else
            mapRemote(model)
    }

    fun mapRemote(model: PostRemote) = Post(
            model.id!!,
            model.userId!!,
            model.title ?: "",
            model.content ?: ""
    )
}
