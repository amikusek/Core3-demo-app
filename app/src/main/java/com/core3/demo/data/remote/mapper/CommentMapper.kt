package com.core3.demo.data.remote.mapper

import com.core3.demo.data.entity.Comment
import com.core3.demo.data.remote.mapper._base.BaseMapper
import com.core3.demo.data.remote.model.CommentRemote

class CommentMapper : BaseMapper<CommentRemote, Comment> {

    override fun mapOrNull(model: CommentRemote): Comment? {
        return if (model.id == null)
            null
        else
            mapRemote(model)
    }

    fun mapRemote(model: CommentRemote) = Comment(
            model.id!!,
            model.title ?: "",
            model.email ?: "",
            model.content ?: ""
    )
}
