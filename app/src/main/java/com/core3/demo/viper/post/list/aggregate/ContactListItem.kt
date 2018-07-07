package com.core3.demo.viper.post.list.aggregate

import com.core3.demo._base.ListingItem
import com.core3.demo.data.entity.Contact

val CONTACT_LIST_ITEM_TYPE = ContactListItem::class.java.hashCode()

class ContactListItem(val contact: Contact) : ListingItem {

    override val type = CONTACT_LIST_ITEM_TYPE
}
