package com.core3.demo.viper.main.list.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.core3.demo._base.ListingItem
import com.core3.demo.R
import com.core3.demo.data.entity.Post
import com.core3.demo.viper.main.list.aggregate.PostListItem
import com.core3.demo.viper.main.list.view_holder.PostViewHolder
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import io.reactivex.subjects.PublishSubject

class PostsAdapterDelegate(private val itemClicksEvents: PublishSubject<Post>) :
        AdapterDelegate<List<ListingItem>>() {

    override fun isForViewType(items: List<ListingItem>, position: Int) =
            items[position].type == PostListItem.TYPE

    override fun onCreateViewHolder(parent: ViewGroup) =
            PostViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_post, parent, false),
                    itemClicksEvents)

    override fun onBindViewHolder(items: List<ListingItem>, position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        (holder as? PostViewHolder)?.bind((items[position] as PostListItem))
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder?) {
        (holder as PostViewHolder).unbind()
        super.onViewDetachedFromWindow(holder)
    }

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        (holder as PostViewHolder).unbind()
        return super.onFailedToRecycleView(holder)
    }
}
