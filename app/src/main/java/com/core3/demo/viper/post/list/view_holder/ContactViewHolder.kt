package com.core3.demo.viper.post.list.view_holder

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.viper.post.list.aggregate.ContactListItem
import kotlinx.android.synthetic.main.viewholder_contact.view.*

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ContactListItem) {
        itemView.run {
            username.text = item.contact.username
            email.text = item.contact.email
            email.paintFlags = email.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
    }
}

