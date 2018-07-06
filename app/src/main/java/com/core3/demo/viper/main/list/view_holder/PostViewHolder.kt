package com.core3.demo.viper.main.list.view_holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.core3.demo.data.entity.Post
import com.core3.demo.extension.retrySubscribe
import com.core3.demo.extension.throttleClicks
import com.core3.demo.viper.main.list.aggregate.PostListItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.viewholder_post.view.*

class PostViewHolder(itemView: View, val listItemClicks: PublishSubject<Post>) :
        RecyclerView.ViewHolder(itemView) {

    private val clicksDisposables = CompositeDisposable()

    fun bind(item: PostListItem) {
        itemView.run {
            title.text = item.post.title
            content.text = item.post.content

            clicksDisposables
                    .add(itemView
                            .throttleClicks()
                            .retrySubscribe(
                                    onNext = { listItemClicks.onNext(item.post) }
                            )
                    )
        }
    }

    fun unbind() = clicksDisposables.dispose()
}
