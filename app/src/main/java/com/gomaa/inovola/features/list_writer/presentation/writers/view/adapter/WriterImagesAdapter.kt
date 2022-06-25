package com.gomaa.inovola.features.list_writer.presentation.writers.view.adapter

import android.view.View
import com.gomaa.inovola.R
import com.gomaa.inovola.base.presentation.view.adapter.BaseRecyclerViewAdapter
import com.gomaa.inovola.base.utils.Utils
import com.gomaa.inovola.databinding.WriterImagesItemBinding

class WriterImagesAdapter :
    BaseRecyclerViewAdapter<String, WriterImagesItemBinding, WriterImagesAdapter.ListWriterImagesViewHolder>(
    ) {
    override fun getLayout(type: Int): Int {
        return R.layout.writer_images_item
    }

    override fun getViewHolder(view: View, type: Int): ListWriterImagesViewHolder {
        return ListWriterImagesViewHolder(view)
    }

    inner class ListWriterImagesViewHolder(itemView: View) :
        BaseRecyclerViewAdapter.BaseRecyclerViewHolder<String, WriterImagesItemBinding>(
            itemView
        ) {

        override fun onBind(item: String) {
            Utils.loadImage(itemView.context, dataBinding?.writerImageView, item)
        }
    }
}