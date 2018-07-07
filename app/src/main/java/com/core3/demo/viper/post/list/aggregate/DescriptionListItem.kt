package com.core3.demo.viper.post.list.aggregate

import com.core3.demo._base.ListingItem

val DESCRIPTION_LIST_ITEM_TYPE = DescriptionListItem::class.java.hashCode()

class DescriptionListItem(val content: String) : ListingItem {

    override val type = DESCRIPTION_LIST_ITEM_TYPE
}
