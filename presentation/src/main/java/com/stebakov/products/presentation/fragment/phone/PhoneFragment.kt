package com.stebakov.products.presentation.fragment.phone

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.BasePhoneCloudDataSource
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import com.stebakov.products.presentation.viewmodel.phone.factory.PhoneViewModelFactory

class PhoneFragment : Fragment() {

    private lateinit var phoneViewModel: PhoneViewModel
    private lateinit var factoryPhone: PhoneViewModelFactory
    private lateinit var recyclerViewHomeStore: RecyclerView
    private lateinit var recyclerViewBestSeller: RecyclerView
    private lateinit var navigationView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_fragment, container, false)
        recyclerViewHomeStore = view.findViewById(R.id.recyclerview_phone_home_store)
        recyclerViewBestSeller = view.findViewById(R.id.recyclerview_phone_best_seller)
        navigationView = view
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val phoneCloud = BasePhoneCloudDataSource(PhoneService())
        val model = BasePhoneModel(phoneCloud)
        factoryPhone = PhoneViewModelFactory(model)
        phoneViewModel = ViewModelProvider(this, factoryPhone).get(PhoneViewModel::class.java)
        phoneViewModel.getPhone()
        phoneViewModel.phones.observe(viewLifecycleOwner, Observer { phones ->
            recyclerViewHomeStore.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = PhoneHomeStoreAdapter(phones, requireContext())
            }
        })
        phoneViewModel.phonesBestSeller.observe(viewLifecycleOwner, { phonesBestSeller ->
            recyclerViewBestSeller.also {
                it.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                it.adapter = PhoneBestSellerAdapter(phonesBestSeller, requireContext(), navigationView)
            }
        })
    }
}