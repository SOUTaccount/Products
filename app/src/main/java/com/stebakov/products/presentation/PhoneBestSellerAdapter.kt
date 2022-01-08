package com.stebakov.products.presentation

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore

class PhoneBestSellerAdapter(
    private val phoneBestSeller: MutableList<PhoneBestSeller>,
    private val context: Context
) : RecyclerView.Adapter<PhoneBestSellerAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhoneViewHolder {
        val itemView =
            LayoutInflater.from(p0.context)
                .inflate(R.layout.recyclerview_phone_bestseller, p0, false)
        return PhoneViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PhoneViewHolder, p1: Int) {
        p0.price.append(phoneBestSeller[p1].mapPriceDiscount().toString())
        p0.subtitle.text = phoneBestSeller[p1].mapTitle()
        p0.oldPrice.append(phoneBestSeller[p1].mapPrice().toString())
        p0.oldPrice.strikeThrough(true)
        Picasso.with(context)
            .load(phoneBestSeller[p1].mapPicture())
            .fit()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(p0.picture)
    }

    override fun getItemCount() = phoneBestSeller.size

    inner class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price = itemView.findViewById<TextView>(R.id.tv_price)!!
        val subtitle = itemView.findViewById<TextView>(R.id.tv_subtitle_phone_best)!!
        val oldPrice = itemView.findViewById<TextView>(R.id.tv_old_price)!!
        val picture = itemView.findViewById<ImageView>(R.id.img_phone_best)!!
    }

    private fun TextView.strikeThrough(enable: Boolean) {
        paintFlags = if (enable) {
            (paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
        } else {
            paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}