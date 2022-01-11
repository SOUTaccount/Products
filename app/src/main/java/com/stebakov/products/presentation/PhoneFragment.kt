package com.stebakov.products.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R
import com.stebakov.products.data.PhoneService
import com.stebakov.products.data.repository.BasePhoneCloudDataSource
import com.stebakov.products.domain.viewmodel.BaseModel
import com.stebakov.products.domain.viewmodel.ViewModel
import com.stebakov.products.domain.viewmodel.ViewModelFactory

class PhoneFragment : Fragment() {

    private lateinit var viewModel: ViewModel
    private lateinit var factory: ViewModelFactory
    private lateinit var recyclerViewHomeStore: RecyclerView
    private lateinit var recyclerViewBestSeller: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_fragment, container, false)
        recyclerViewHomeStore = view.findViewById(R.id.recyclerview_phone_home_store)
        recyclerViewBestSeller = view.findViewById(R.id.recyclerview_phone_best_seller)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val phoneCloud = BasePhoneCloudDataSource(PhoneService())
        val model = BaseModel(phoneCloud)
        factory = ViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(ViewModel::class.java)
        viewModel.getPhone()
        viewModel.phoneHomeStore.observe(viewLifecycleOwner, Observer { phoneHomeStore ->
            recyclerViewHomeStore.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = PhoneHomeStoreAdapter(phoneHomeStore, requireContext())
            }
        })

        viewModel.phoneBestSeller.observe(viewLifecycleOwner, Observer { phoneBestSeller ->
            recyclerViewBestSeller.also {
                it.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                it.adapter = PhoneBestSellerAdapter(phoneBestSeller, requireContext())
            }
        })
    }
}