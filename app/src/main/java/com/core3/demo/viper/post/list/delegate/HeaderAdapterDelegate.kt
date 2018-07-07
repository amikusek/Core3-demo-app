package com.core3.demo.viper.post.list.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.core3.demo.R
import com.core3.demo._base.ListingItem
import com.core3.demo.viper.post.list.aggregate.HEADER_LIST_ITEM_TYPE
import com.core3.demo.viper.post.list.aggregate.HeaderListItem
import com.core3.demo.viper.post.list.view_holder.HeaderViewHolder
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate

class HeaderAdapterDelegate : AdapterDelegate<List<ListingItem>>() {

    override fun isForViewType(items: List<ListingItem>, position: Int) =
            items[position].type == HEADER_LIST_ITEM_TYPE

    override fun onCreateViewHolder(parent: ViewGroup) =
            HeaderViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_header, parent, false))

    override fun onBindViewHolder(items: List<ListingItem>, position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        (holder as? HeaderViewHolder)?.bind((items[position] as HeaderListItem))
    }
}
