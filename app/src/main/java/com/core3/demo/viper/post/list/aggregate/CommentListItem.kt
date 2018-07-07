package com.core3.demo.viper.post.list.aggregate

import com.core3.demo._base.ListingItem
import com.core3.demo.data.entity.Comment

val COMMENT_LIST_ITEM_TYPE = CommentListItem::class.java.hashCode()

class CommentListItem(val comment: Comment) : ListingItem {

    override val type = COMMENT_LIST_ITEM_TYPE
}
