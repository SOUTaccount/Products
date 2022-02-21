package com.stebakov.products.presentation.fragment.phone

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.helpers.PriceHelperImpl
import com.stebakov.products.databinding.RecyclerviewPhoneBestsellerBinding

class PhoneBestSellerAdapter(
    private val phoneBestSeller: List<PhoneBestSellerServerModel>,
    private val context: Context,
    private val navigationView: View
) : RecyclerView.Adapter<PhoneBestSellerAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewPhoneBestsellerBinding.inflate(layoutInflater, parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.bind(phoneBestSeller[position], position)
    }

    override fun getItemCount() = phoneBestSeller.size

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    inner class PhoneViewHolder(private val viewBinding: RecyclerviewPhoneBestsellerBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: PhoneBestSellerServerModel, position: Int) {
            with(viewBinding) {
                tvPrice.text = item.priceDiscount.let {
                    if (it != null) PriceHelperImpl().mapIntToPriceForProduct(it) else ""
                }
                tvOldPrice.text = item.price.let {
                    if (it != null) PriceHelperImpl().mapIntToPriceForProduct(it) else ""
                }
                tvSubtitlePhoneBest.text = item.title
                tvOldPrice.strikeThrough(true)
                if (item.isFavorites)
                    imgBtnFavorite.setImageResource(R.drawable.outline_favorite_24)
                else imgBtnFavorite.setImageResource(R.drawable.outline_favorite_border_24)
                imgBtnFavorite.setOnClickListener {
                    item.isFavorites = !item.isFavorites
                    notifyItemChanged(position)
                }
                imgPhoneBest.setOnClickListener {
                    Navigation.findNavController(navigationView)
                        .navigate(R.id.action_mainFragment_to_phoneDetailFragment)
                }
                Picasso.with(context)
                    .load(item.picture)
                    .fit()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imgPhoneBest)
            }
        }
    }
}

private fun TextView.strikeThrough(enable: Boolean) {
    paintFlags = if (enable) {
        (paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
    } else {
        paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}