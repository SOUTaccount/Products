package com.stebakov.products.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.products.domain.model.PhoneHomeStore

class PhoneHomeStoreAdapter(
    private val phoneHomeStore : MutableList<PhoneHomeStore>,
    private val context: Context
) : RecyclerView.Adapter<PhoneHomeStoreAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhoneViewHolder {
        val itemView =
            LayoutInflater.from(p0.context).inflate(R.layout.recyclerview_phone_homestore, p0, false)
        return PhoneViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PhoneViewHolder, p1: Int) {
        p0.title.text = phoneHomeStore[p1].mapTitle()
        p0.subtitle.text = phoneHomeStore[p1].mapSubTitle()
        Picasso.with(context)
            .load(phoneHomeStore[p1].mapPicture())
            .fit()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(p0.picture)
    }

    override fun getItemCount() = phoneHomeStore.size

    inner class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title)!!
        val subtitle = itemView.findViewById<TextView>(R.id.tv_subtitle)!!
        val picture = itemView.findViewById<ImageView>(R.id.imageView)!!
    }
}