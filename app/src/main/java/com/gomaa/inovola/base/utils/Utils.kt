package com.gomaa.inovola.base.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gomaa.inovola.R

class Utils {
    companion object {
        fun loadImage(context: Context, imageView: ImageView?, imageUlr: String?) {
            if (imageView != null)
                Glide.with(context).load(imageUlr).placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)

        }

        fun Alert(context: Context, title: String, desc: String) {
            AlertDialog.Builder(context).setTitle(title).setMessage(desc).setCancelable(false)
                .setPositiveButton(android.R.string.ok) { _, _ -> }.create().show()
        }
    }
}