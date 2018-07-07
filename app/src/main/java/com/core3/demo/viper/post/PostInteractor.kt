package com.core3.demo.viper.post

import com.core3.demo.data.sync.SyncableRepository
import com.core3.demo.data.sync.query.remote.GetPostCommentsQuery
import com.core3.demo.data.sync.query.remote.GetUserQuery
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor

class PostInteractor : BaseRxInteractor(), PostContract.Interactor {

    private val repository = SyncableRepository()

    override fun getUser(id: Int) = repository.query(GetUserQuery(id))

    override fun getComments(id: Int) = repository.query(GetPostCommentsQuery(id))
}
