package com.core3.demo.viper.main.list.aggregate

import com.core3.demo._base.ListingItem
import com.core3.demo.data.entity.Post

class PostListItem(val post: Post) : ListingItem {

    override val type = TYPE

    companion object {
        var TYPE = PostListItem::class.java.hashCode()
    }
}
