package com.cst.academy2024unibucfmi.utils.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cst.academy2024unibucfmi.R

@BindingAdapter("url")
fun loadImageFromUrl(
    imageView: ImageView,
    url: String?
) = url?.let {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_user)
        .into(imageView)
}