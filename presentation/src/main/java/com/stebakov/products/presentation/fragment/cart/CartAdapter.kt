package com.stebakov.products.presentation.fragment.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.domain.entity.network.Basket
import com.stebakov.domain.helpers.PriceHelper
import com.stebakov.products.R
import com.stebakov.products.databinding.RecyclerviewCartBinding

class CartAdapter(private val listBasket: List<Basket>?, private val context: Context) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewCartBinding.inflate(layoutInflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(listBasket!![position])
    }

    override fun getItemCount() = listBasket!!.size

    inner class CartViewHolder(private val binding: RecyclerviewCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Basket) {
            with(binding) {
                Picasso.with(context)
                    .load(item.images)
                    .fit()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivPhonePhotoMyCart)
                tvPhoneNameMyCart.text = item.title
                tvPhonePriceMyCart.text = PriceHelper().parsePriceToCartAdapter(item.price)
            }
        }
    }

}