package com.core3.demo.viper.post.list.view_holder

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.R
import com.core3.demo.viper.post.list.aggregate.HeaderListItem
import kotlinx.android.synthetic.main.viewholder_header.view.*

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: HeaderListItem) {
        itemView.run {
            title.text = item.title

            if (item.isHighlighted)
                setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            else
                setBackgroundColor(ContextCompat.getColor(context, R.color.background))
        }
    }
}
