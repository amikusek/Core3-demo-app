package com.core3.demo.viper.main

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.core3.demo.R
import com.core3.demo.data.entity.Post
import com.core3.demo.extension.makeGone
import com.core3.demo.extension.makeVisible
import com.core3.demo.viper.main.list.PostsAdapter
import com.core3.demo.viper.main.list.aggregate.PostListItem
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ViperAiPassiveActivity<MainContract.View>(), MainContract.View {

    private val adapter = PostsAdapter()

    override val listItemClicksEvents = adapter.itemClicksEvents

    override fun injectViews() {
        super.injectViews()
        setRecyclerView()
    }

    override fun setList(posts: List<Post>) {
        adapter.listingItems = posts.map { PostListItem(it) }
        adapter.notifyDataSetChanged()
    }

    override fun showList() {
        postList.makeVisible()
        loadingView.makeGone()
        emptyState.makeGone()
    }

    override fun showLoading() {
        postList.makeGone()
        loadingView.makeVisible()
        emptyState.makeGone()
    }

    override fun showEmptyView() {
        postList.makeGone()
        loadingView.makeGone()
        emptyState.makeVisible()
    }

    override fun showError(throwable: Throwable) =
            Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show()

    private fun setRecyclerView() {
        postList.adapter = adapter
        postList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun createPresenter() = MainPresenter()

    override fun getLayoutId() = R.layout.activity_main
}
