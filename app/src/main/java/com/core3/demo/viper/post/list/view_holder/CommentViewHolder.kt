package com.core3.demo.viper.post.list.view_holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.viper.post.list.aggregate.CommentListItem
import kotlinx.android.synthetic.main.viewholder_comment.view.*

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: CommentListItem) {
        itemView.run {
            title.text = item.comment.content
            username.text = item.comment.email
            content.text = item.comment.content
        }
    }
}
