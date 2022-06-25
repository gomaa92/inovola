package com.gomaa.inovola.base.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseRecyclerViewAdapter<T, VB : ViewDataBinding, V : BaseRecyclerViewAdapter.BaseRecyclerViewHolder<T, VB>>(
) : RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseRecyclerViewHolder<T, VB>>() {

    var mData: ArrayList<T>

    init {
        this.mData = ArrayList()
    }

    constructor(mData: ArrayList<T>) : this() {
        this.mData = ArrayList()
        addItems(mData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<T, VB> {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(getLayout(viewType), parent, false)
        return getViewHolder(view, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<T, VB>, position: Int) {

        mData[position]?.let { holder.onBind(it) }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    protected abstract fun getLayout(type: Int): Int
    protected abstract fun getViewHolder(view: View, type: Int): V


    fun addItems(items: List<T>?) {
        if (items != null) {
            mData.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun setItems(items: List<T>?) {
        mData.clear()
        mData.addAll(items!!)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        mData.add(item)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mData.removeAt(position)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mData.clear()
        notifyDataSetChanged()
    }

    fun getData(): ArrayList<T> {
        return mData

    }

    abstract class BaseRecyclerViewHolder<T, VB : ViewDataBinding>(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        protected val dataBinding by lazy { DataBindingUtil.bind<VB>(itemView) }
        abstract fun onBind(item: T)
    }

}