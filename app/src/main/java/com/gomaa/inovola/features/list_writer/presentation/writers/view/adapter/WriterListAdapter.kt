package com.gomaa.inovola.features.list_writer.presentation.writers.view.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gomaa.inovola.R
import com.gomaa.inovola.base.presentation.view.adapter.BaseRecyclerViewAdapter
import com.gomaa.inovola.databinding.WritersLayoutItemBinding
import com.gomaa.inovola.features.list_writer.data.model.ResultsEntity
import com.gomaa.inovola.features.list_writer.presentation.writers.listener.ShowItemDetailsListener

class WriterListAdapter(private val mListener: ShowItemDetailsListener) :
    BaseRecyclerViewAdapter<ResultsEntity, WritersLayoutItemBinding, WriterListAdapter.ListWritersViewHolder>(
    ) {
    override fun getLayout(type: Int): Int {
        return R.layout.writers_layout_item
    }

    override fun getViewHolder(view: View, type: Int): ListWritersViewHolder {
        return ListWritersViewHolder(view)
    }

    inner class ListWritersViewHolder(itemView: View) :
        BaseRecyclerViewAdapter.BaseRecyclerViewHolder<ResultsEntity, WritersLayoutItemBinding>(
            itemView
        ) {


        override fun onBind(item: ResultsEntity) {
            val adapter = WriterImagesAdapter()
            dataBinding?.writerRecyclerView?.layoutManager =
                object : LinearLayoutManager(itemView.context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                        lp?.width = width / 2
                        return super.checkLayoutParams(lp)
                    }
                }
            dataBinding?.nameTextView?.text = item.name
            dataBinding?.writerRecyclerView?.adapter = adapter
            adapter.addItems(items = item.imageUrlsThumbnails)
            adapter.notifyItemInserted(adapter.itemCount - 1)
            dataBinding?.detailTextView?.setOnClickListener { mListener.onItemClickedListener(item) }


        }
    }
}