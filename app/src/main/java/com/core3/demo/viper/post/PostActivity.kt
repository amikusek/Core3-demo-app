package com.core3.demo.viper.post

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.core3.demo.R
import com.core3.demo._base.ListingItem
import com.core3.demo.constants.POST_ARGS
import com.core3.demo.data.entity.Comment
import com.core3.demo.data.entity.Contact
import com.core3.demo.data.entity.Post
import com.core3.demo.data.entity.User
import com.core3.demo.extension.makeGone
import com.core3.demo.extension.makeVisible
import com.core3.demo.viper.post.list.PostDetailsAdapter
import com.core3.demo.viper.post.list.aggregate.CommentListItem
import com.core3.demo.viper.post.list.aggregate.ContactListItem
import com.core3.demo.viper.post.list.aggregate.DescriptionListItem
import com.core3.demo.viper.post.list.aggregate.HeaderListItem
import com.jakewharton.rxbinding2.support.v7.widget.navigationClicks
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : ViperAiPassiveActivity<PostContract.View>(), PostContract.View {

    private val adapter = PostDetailsAdapter()

    override val post by lazy { args.getParcelable<Post>(POST_ARGS) }
    override val emailClickEvents = adapter.emailClickEvents
    override val backButtonClicks
        get() = toolbar.navigationClicks()

    override fun injectViews() {
        super.injectViews()
        setRecyclerView()
    }

    override fun render(user: User, comments: List<Comment>) =
            with(mutableListOf<ListingItem>()) {
                post?.let {
                    add(HeaderListItem(post!!.title, true))
                    add(DescriptionListItem(post.content))
                    add(ContactListItem(Contact(user.name, user.email)))
                    add(HeaderListItem("Comments", false))
                    comments.forEach {
                        add(CommentListItem(it))
                    }
                }
                adapter.listingItems = this
                adapter.notifyDataSetChanged()
            }

    override fun showList() {
        postDetailsContent.makeVisible()
        loadingView.makeGone()
        emptyState.makeGone()
    }

    override fun showLoading() {
        postDetailsContent.makeGone()
        loadingView.makeVisible()
        emptyState.makeGone()
    }

    override fun showEmptyView() {
        postDetailsContent.makeGone()
        loadingView.makeGone()
        emptyState.makeVisible()
    }

    override fun showError(throwable: Throwable) =
            Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show()

    private fun setRecyclerView() {
        postDetailsContent.adapter = adapter
        postDetailsContent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun createPresenter() = PostPresenter()

    override fun getLayoutId() = R.layout.activity_post
}
