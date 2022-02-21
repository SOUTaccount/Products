package com.stebakov.products.presentation.fragment.phone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stebakov.products.R
import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel
import com.stebakov.products.databinding.RecyclerviewPhoneHomestoreBinding

class PhoneHomeStoreAdapter(
    private val phoneHomeStore: List<PhoneHomeStoreServerModel>,
    private val context: Context
) : RecyclerView.Adapter<PhoneHomeStoreAdapter.PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewPhoneHomestoreBinding.inflate(layoutInflater, parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.bind(phoneHomeStore[position])
    }

    override fun getItemCount() = phoneHomeStore.size

    inner class PhoneViewHolder(private val viewBinding: RecyclerviewPhoneHomestoreBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: PhoneHomeStoreServerModel) {
            with(viewBinding) {
                tvTitle.text = item.title
                tvSubtitle.text = item.subtitle
                if (item.isNew) tvNew.visibility = View.VISIBLE
                else tvNew.visibility = View.GONE

                Picasso.with(context)
                    .load(item.picture)
                    .fit()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivPhonePhoto)
            }
        }
    }
}