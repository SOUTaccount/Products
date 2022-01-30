package com.stebakov.products.presentation.fragment.phonedetail.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.stebakov.products.R
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.BasePhoneCloudDataSource
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Details
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Features
import com.stebakov.products.presentation.viewmodel.detail.BaseDetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import com.stebakov.products.presentation.viewmodel.detail.factory.DetailViewModelFactory
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.FragmentCharacteristicsAdapter
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Shop


class PhoneDetailFragment : Fragment() {
    private lateinit var recyclerViewImage: RecyclerView
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var factory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel
    private lateinit var phoneName: TextView
    private val characteristics = listOf(Shop, Details, Features)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_detail_fragment, container, false)
        recyclerViewImage = view.findViewById(R.id.rv_image_phone_detail)
        viewPager = view.findViewById(R.id.viewpager_detail)
        tabLayout = view.findViewById(R.id.tab_detail)
        phoneName = view.findViewById(R.id.tv_phone_name_detail)
        val adapter = FragmentCharacteristicsAdapter(requireActivity(), characteristics)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = characteristics[position].name
        }.attach()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val phoneCloud = BasePhoneCloudDataSource(PhoneService())
        val model = BaseDetailModel(phoneCloud)
        factory = DetailViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        viewModel.getDetail()
        viewModel.phoneDetail.observe(viewLifecycleOwner, Observer { phoneDetail ->
            recyclerViewImage.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.adapter = ImageDetailAdapter(phoneDetail, requireContext())
                phoneName.text = phoneDetail.title
            }
        })
    }
}