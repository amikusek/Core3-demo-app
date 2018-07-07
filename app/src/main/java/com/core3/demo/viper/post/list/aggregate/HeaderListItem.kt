package com.core3.demo.viper.post.list.aggregate

import com.core3.demo._base.ListingItem

val HEADER_LIST_ITEM_TYPE = HeaderListItem::class.java.hashCode()

class HeaderListItem(val title: String,
                     val isHighlighted: Boolean) : ListingItem {

    override val type = HEADER_LIST_ITEM_TYPE
}
