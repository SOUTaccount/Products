package com.stebakov.products.presentation.fragment.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.domain.entity.database.FavoritePhone
import com.stebakov.products.R
import com.stebakov.products.databinding.RecyclerViewFavoritePhonesBinding

class FavoritePhonesAdapter(private val favoritePhones: List<FavoritePhone>) :
    RecyclerView.Adapter<FavoritePhonesAdapter.FavoritePhonesViewHolder>() {


    inner class FavoritePhonesViewHolder(private val viewBinding: RecyclerViewFavoritePhonesBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: FavoritePhone) {
            with(viewBinding) {
                tvFavoritePhoneName.text = item.name
                Picasso.with(this@FavoritePhonesViewHolder.itemView.context)
                    .load(item.picture)
                    .fit()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivFavoritePhoneImage)
                tvFavoritePhonePrice.text = item.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritePhonesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewFavoritePhonesBinding.inflate(layoutInflater, parent, false)
        return FavoritePhonesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritePhonesViewHolder, position: Int) {
        holder.bind(favoritePhones[position])
    }

    override fun getItemCount(): Int {
        return favoritePhones.size
    }
}