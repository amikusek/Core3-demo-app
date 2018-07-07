package com.core3.demo.viper.post.list.view_holder

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.data.entity.Contact
import com.core3.demo.extension.retrySubscribe
import com.core3.demo.extension.throttleClicks
import com.core3.demo.viper.post.list.aggregate.ContactListItem
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.viewholder_contact.view.*

class ContactViewHolder(itemView: View, val emailClickEvents: PublishSubject<Contact>) :
        RecyclerView.ViewHolder(itemView) {

    fun bind(item: ContactListItem) {
        itemView.run {
            username.text = item.contact.username
            email.text = item.contact.email
            email.paintFlags = email.paintFlags or Paint.UNDERLINE_TEXT_FLAG

            email
                    .throttleClicks()
                    .retrySubscribe(
                            onNext = { emailClickEvents.onNext(item.contact) })
        }
    }
}
