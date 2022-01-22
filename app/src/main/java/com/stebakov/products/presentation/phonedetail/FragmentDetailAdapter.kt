package com.stebakov.products.presentation.phonedetail

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stebakov.products.presentation.*
import com.stebakov.products.presentation.phone.PhoneFragment

class FragmentDetailAdapter (
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