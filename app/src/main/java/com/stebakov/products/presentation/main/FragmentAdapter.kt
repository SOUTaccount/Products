package com.stebakov.products.presentation.main

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stebakov.products.presentation.*
import com.stebakov.products.presentation.phone.PhoneFragment

class FragmentAdapter(
    fragment: FragmentActivity,
    private val typeOfProducts: List<TypeOfProducts>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = typeOfProducts.size
    override fun createFragment(position: Int) =
        when (typeOfProducts[position]) {
            is Phones -> PhoneFragment()
            is Computers -> PhoneFragment()
            is Health -> PhoneFragment()
            is Books -> PhoneFragment()
            is Gifts -> PhoneFragment()
            is Sport -> PhoneFragment()
        }
}