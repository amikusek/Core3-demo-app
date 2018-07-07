package com.core3.demo.viper.post.list.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.core3.demo.R
import com.core3.demo._base.ListingItem
import com.core3.demo.data.entity.Contact
import com.core3.demo.viper.post.list.aggregate.CONTACT_LIST_ITEM_TYPE
import com.core3.demo.viper.post.list.aggregate.ContactListItem
import com.core3.demo.viper.post.list.view_holder.ContactViewHolder
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import io.reactivex.subjects.PublishSubject

class ContactAdapterDelegate(val emailClickEvents: PublishSubject<Contact>) : AdapterDelegate<List<ListingItem>>() {

    override fun isForViewType(items: List<ListingItem>, position: Int) =
            items[position].type == CONTACT_LIST_ITEM_TYPE

    override fun onCreateViewHolder(parent: ViewGroup) =
            ContactViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_contact, parent, false),
                    emailClickEvents)

    override fun onBindViewHolder(items: List<ListingItem>, position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        (holder as? ContactViewHolder)?.bind((items[position] as ContactListItem))
    }
}
