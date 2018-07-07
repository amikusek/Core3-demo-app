package com.core3.demo.data.remote.mapper

import com.core3.demo.data.entity.User
import com.core3.demo.data.remote.mapper._base.BaseMapper
import com.core3.demo.data.remote.model.UserRemote

class UserMapper : BaseMapper<UserRemote, User> {

    override fun mapOrNull(model: UserRemote): User? {
        return if (model.id == null)
            null
        else
            mapRemote(model)
    }

    fun mapRemote(model: UserRemote) = User(
            model.id ?: -1,
            model.name ?: "",
            model.username ?: "",
            model.email ?: ""
    )
}
