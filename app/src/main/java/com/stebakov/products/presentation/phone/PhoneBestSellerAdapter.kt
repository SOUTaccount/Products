package com.stebakov.products.presentation.phone

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.products.data.model.PhoneBestSellerServerModel

class PhoneBestSellerAdapter(
    private val phoneBestSeller: List<PhoneBestSellerServerModel>,
    private val context: Context,
    private val navigationView: View
) : RecyclerView.Adapter<PhoneBestSellerAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhoneViewHolder {
        val itemView =
            LayoutInflater.from(p0.context)
                .inflate(R.layout.recyclerview_phone_bestseller, p0, false)
        return PhoneViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(p0: PhoneViewHolder, p1: Int) {
        p0.apply {
            price.text = "$" + (phoneBestSeller[p1].priceDiscount.toString())
            subtitle.text = phoneBestSeller[p1].title
            oldPrice.text = "$" + phoneBestSeller[p1].price.toString()
            oldPrice.strikeThrough(true)
            if (phoneBestSeller[p1].isFavorites)
                favoriteBtn.setImageResource(R.drawable.outline_favorite_24)
            else favoriteBtn.setImageResource(R.drawable.outline_favorite_border_24)
            favoriteBtn.setOnClickListener {
                phoneBestSeller[p1].isFavorites = !phoneBestSeller[p1].isFavorites
                notifyDataSetChanged()
            }
            picture.setOnClickListener {
                Navigation.findNavController(navigationView).navigate(R.id.action_mainFragment_to_phoneDetailFragment)
            }
        }
        Picasso.with(context)
            .load(phoneBestSeller[p1].picture)
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
        val favoriteBtn = itemView.findViewById<ImageButton>(R.id.img_btn_favorite)!!
    }

    private fun TextView.strikeThrough(enable: Boolean) {
        paintFlags = if (enable) {
            (paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
        } else {
            paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}