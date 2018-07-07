package com.core3.demo.viper.post.list

import com.core3.demo._base.BaseRecyclerAdapter
import com.core3.demo._base.ListingItem
import com.core3.demo.viper.post.list.aggregate.*
import com.core3.demo.viper.post.list.delegate.CommentAdapterDelegate
import com.core3.demo.viper.post.list.delegate.ContactAdapterDelegate
import com.core3.demo.viper.post.list.delegate.DescriptionAdapterDelegate
import com.core3.demo.viper.post.list.delegate.HeaderAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager

class PostDetailsAdapter : BaseRecyclerAdapter<ListingItem>() {

    override fun addAdapterDelegates(delegatesManager: AdapterDelegatesManager<List<ListingItem>>) {
        delegatesManager.addDelegate(HEADER_LIST_ITEM_TYPE, HeaderAdapterDelegate())
        delegatesManager.addDelegate(DESCRIPTION_LIST_ITEM_TYPE, DescriptionAdapterDelegate())
        delegatesManager.addDelegate(COMMENT_LIST_ITEM_TYPE, CommentAdapterDelegate())
        delegatesManager.addDelegate(CONTACT_LIST_ITEM_TYPE, ContactAdapterDelegate())
    }
}
