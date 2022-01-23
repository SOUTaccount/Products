package com.stebakov.products.presentation.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.stebakov.products.R
import com.stebakov.domain.entity.*


class MainFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val typeOfProducts = listOf(Phones, Computers, Health, Books, Gifts, Sport)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        viewPager = view.findViewById(R.id.viewpager_main)
        tabLayout = view.findViewById(R.id.tab_main)
        val adapter = FragmentAdapter(requireActivity(), typeOfProducts)
        viewPager.adapter = adapter
        stopScroll(viewPager)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.customView = getView(position)
        }.attach()
        return view
    }

    private fun stopScroll(viewPager2: ViewPager2) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                viewPager.isUserInputEnabled =
                    !(state == ViewPager2.SCROLL_STATE_DRAGGING && viewPager.currentItem == 0)
            }
        })
    }

    private fun getView(position: Int): View {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.phone_view, null)
        val drawable = view.findViewById<ImageView>(R.id.img_tab)
        val title = view.findViewById<TextView>(R.id.tv_tab)
        drawable.setImageResource(typeOfProducts[position].drawable)
        title.text = typeOfProducts[position].name
        return view
    }

}