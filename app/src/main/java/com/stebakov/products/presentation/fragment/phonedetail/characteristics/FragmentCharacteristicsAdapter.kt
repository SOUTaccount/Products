package com.stebakov.products.presentation.fragment.phonedetail.characteristics

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stebakov.products.domain.entity.Characteristics
import com.stebakov.products.domain.entity.Details
import com.stebakov.products.domain.entity.Features
import com.stebakov.products.domain.entity.Shop

class FragmentCharacteristicsAdapter (
    fragment: FragmentActivity,
    private val characteristics: List<Characteristics>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = characteristics.size
    override fun createFragment(position: Int) =
        when (characteristics[position]) {
            is Shop -> PhoneCharacteristicsFragment()
            is Details -> PhoneCharacteristicsFragment()
            is Features -> PhoneCharacteristicsFragment()
        }
}