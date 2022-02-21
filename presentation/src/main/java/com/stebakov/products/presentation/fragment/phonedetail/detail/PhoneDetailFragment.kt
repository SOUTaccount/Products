package com.stebakov.products.presentation.fragment.phonedetail.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import com.stebakov.products.R
import com.stebakov.products.databinding.PhoneDetailFragmentBinding
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Details
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Features
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.FragmentCharacteristicsAdapter
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Shop
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhoneDetailFragment : Fragment(R.layout.phone_detail_fragment) {

    private val detailViewModel by viewModel<DetailViewModel>()
    private val characteristics = listOf(Shop, Details, Features)
    private var viewBinding: PhoneDetailFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = PhoneDetailFragmentBinding.bind(view)
        val adapter = FragmentCharacteristicsAdapter(requireActivity(), characteristics)
        with(viewBinding!!) {
            viewpagerDetail.adapter = adapter
            TabLayoutMediator(tabDetail, viewpagerDetail) { tab, position ->
                tab.text = characteristics[position].name
            }.attach()
            ivCartContainerProductDetails.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_phoneDetailFragment_to_cartFragment)
            }
            detailViewModel.getDetail()
            detailViewModel.phoneDetail.observe(viewLifecycleOwner) { phoneDetail ->
                rvImagePhoneProductDetails.also {
                    it.setItemTransformer(
                        ScaleTransformer.Builder()
                            .setMaxScale(1.0f)
                            .setMinScale(0.3f)
                            .setPivotX(Pivot.X.CENTER)
                            .setPivotY(Pivot.Y.CENTER)
                            .build()
                    )
                    it.adapter = ImageDetailAdapter(phoneDetail, requireContext())
                    tvPhoneNameDetail.text = phoneDetail.title
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}