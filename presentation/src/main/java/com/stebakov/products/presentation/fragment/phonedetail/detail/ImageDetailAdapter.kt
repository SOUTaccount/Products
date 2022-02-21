package com.stebakov.products.presentation.fragment.phonedetail.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.products.databinding.RecyclerviewPhoneImageBinding

class ImageDetailAdapter(
    private val phoneDetail: PhoneDetailServerModel,
    private val context: Context
) : RecyclerView.Adapter<ImageDetailAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewPhoneImageBinding.inflate(layoutInflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(phoneDetail.images[position])
    }

    override fun getItemCount() = phoneDetail.images.size

    inner class ImageViewHolder(private val viewBinding: RecyclerviewPhoneImageBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(image: String) {
            Picasso.with(context)
                .load(image)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewBinding.imgPhoneDetail)
        }
    }
}