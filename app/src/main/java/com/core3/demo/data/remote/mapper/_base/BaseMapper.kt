package com.core3.demo.data.remote.mapper._base

interface BaseMapper<M, E> {
    fun mapOrNull(model: M): E?
}
