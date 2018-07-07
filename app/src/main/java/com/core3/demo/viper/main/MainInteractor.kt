package com.core3.demo.viper.main

import com.core3.demo.data.sync.SyncableRepository
import com.core3.demo.data.sync.query.remote.GetPostsQuery
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor

class MainInteractor : BaseRxInteractor(), MainContract.Interactor {

    override fun getPosts() = SyncableRepository().query(GetPostsQuery())
}
