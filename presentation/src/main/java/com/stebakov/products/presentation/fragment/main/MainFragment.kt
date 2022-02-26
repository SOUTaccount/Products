package com.stebakov.products.presentation.fragment.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.ArrayRes
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.stebakov.products.R
import com.stebakov.products.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private val typeOfProducts = listOf(Phones, Computers, Health, Books, Gifts, Sport)
    private var viewBinding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)
        val bottomSheetDialogFragment =
            BottomSheetBehavior.from(viewBinding!!.bottomSheet.bottomSheetMainScreen)
        with(viewBinding!!) {
            bottomSheet.ivCloseContainer.setOnClickListener {
                bottomSheetDialogFragment.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            ivFilter.setOnClickListener {
                if (bottomSheetDialogFragment.state != BottomSheetBehavior.STATE_EXPANDED)
                    bottomSheetDialogFragment.state = BottomSheetBehavior.STATE_EXPANDED
                else bottomSheetDialogFragment.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        initSpinner(viewBinding!!.bottomSheet.spinnerBrand, R.array.brand_phone_array)
        initSpinner(viewBinding!!.bottomSheet.spinnerPrice, R.array.price_phone_array)
        initSpinner(viewBinding!!.bottomSheet.spinnerSize, R.array.size_phone_array)
        with(viewBinding!!) {
            ivShopNavigationView.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_mainFragment_to_cartFragment)
            }
            ivFavoritesNavigationView.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_mainFragment_to_favoritePhonesFragment)
            }
            val adapter = FragmentAdapter(requireActivity(), typeOfProducts)
            viewpagerMain.adapter = adapter
            stopScroll(viewpagerMain)
            TabLayoutMediator(tabMain, viewpagerMain) { tab, position ->
                tab.customView = getView(position)
            }.attach()
        }
    }

    private fun stopScroll(viewPager2: ViewPager2) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                viewPager2.isUserInputEnabled =
                    !(state == ViewPager2.SCROLL_STATE_DRAGGING && viewPager2.currentItem == 0)
            }
        })
    }

    @SuppressLint("InflateParams")
    private fun getView(position: Int): View {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.phone_view, null)
        val drawable = view.findViewById<ImageView>(R.id.img_tab)
        val title = view.findViewById<TextView>(R.id.tv_tab)
        drawable.setImageResource(typeOfProducts[position].drawable)
        title.text = typeOfProducts[position].name
        return view
    }

    private fun initSpinner(spinner: Spinner, @ArrayRes textArrayResId: Int) {
        ArrayAdapter.createFromResource(
            this.requireContext(),
            textArrayResId,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}