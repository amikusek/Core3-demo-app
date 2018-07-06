package com.core3.demo._base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.core3.demo.extension.retrySubscribe
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import io.reactivex.subjects.PublishSubject

abstract class BaseRecyclerAdapter<ItemType> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var displayedItems: List<ItemType> = listOf()
    private val adapterDelegates by lazy {
        AdapterDelegatesManager<List<ItemType>>().apply {
            addAdapterDelegates(this)
        }
    }

    abstract fun addAdapterDelegates(delegatesManager: AdapterDelegatesManager<List<ItemType>>)

    private val itemQueue = PublishSubject.create<List<ItemType>>()!!
    var listingItems: List<ItemType> = listOf()
        set(value) {
            field = value
            itemQueue.onNext(value)
        }

    init {
        itemQueue
                .retrySubscribe(
                        onNext = {
                            displayedItems = it
                            notifyDataSetChanged()
                        }
                )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            adapterDelegates.onBindViewHolder(displayedItems, position, holder)

    override fun getItemCount() = displayedItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            adapterDelegates.onCreateViewHolder(parent, viewType)

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) =
            adapterDelegates.onViewRecycled(holder)

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        adapterDelegates.onFailedToRecycleView(holder)
        return super.onFailedToRecycleView(holder)
    }

    override fun getItemViewType(position: Int) = adapterDelegates.getItemViewType(displayedItems, position)
}
