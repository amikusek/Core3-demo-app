package com.core3.demo.viper.post.list.view_holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.viper.post.list.aggregate.DescriptionListItem
import kotlinx.android.synthetic.main.viewholder_description.view.*

class DescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: DescriptionListItem) {
        itemView.run {
            description.text = item.content
        }
    }
}
