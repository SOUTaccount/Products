package com.stebakov.products.presentation.fragment.phonedetail.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.products.data.entity.PhoneDetailServerModel

class ImageDetailAdapter(
    private val phoneDetail: PhoneDetailServerModel,
    private val context: Context
) : RecyclerView.Adapter<ImageDetailAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageViewHolder {
        val itemView =
            LayoutInflater.from(p0.context)
                .inflate(R.layout.recyclerview_phone_image, p0, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: ImageViewHolder, p1: Int) {
        Picasso.with(context)
            .load(phoneDetail.images[p1])
            .fit()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(p0.image)
    }

    override fun getItemCount() = phoneDetail.images.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.img_phone_detail)!!
    }
}