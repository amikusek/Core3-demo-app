package com.core3.demo.viper.main.list

import com.core3.demo._base.ListingItem
import com.core3.demo._base.BaseRecyclerAdapter
import com.core3.demo.data.entity.Post
import com.core3.demo.viper.main.list.aggregate.PostListItem
import com.core3.demo.viper.main.list.delegate.PostsAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import io.reactivex.subjects.PublishSubject

class PostsAdapter : BaseRecyclerAdapter<ListingItem>() {

    val itemClicksEvents = PublishSubject.create<Post>()!!

    override fun addAdapterDelegates(delegatesManager: AdapterDelegatesManager<List<ListingItem>>) {
        delegatesManager.addDelegate(PostListItem.TYPE, PostsAdapterDelegate(itemClicksEvents))
    }
}
