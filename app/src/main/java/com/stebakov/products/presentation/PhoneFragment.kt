package com.stebakov.products.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R
import com.stebakov.products.data.PhoneService
import com.stebakov.products.data.repository.BasePhoneCloudDataSource
import com.stebakov.products.domain.BaseModel
import com.stebakov.products.domain.ViewModel
import com.stebakov.products.domain.ViewModelFactory
import com.stebakov.products.domain.callback.DataCallback
import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        val retrofit = Retrofit.Builder()
            .baseUrl("https://db2021ecom-edca.restdb.io/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val phoneCloud = BasePhoneCloudDataSource(retrofit.create(PhoneService::class.java))
        val model = BaseModel(phoneCloud)
        factory = ViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(ViewModel::class.java)
        viewModel.getPhone()
        viewModel.init(object : DataCallback {
            override fun provideData(
                homeStore: MutableList<PhoneHomeStore>,
                bestSeller: MutableList<PhoneBestSeller>
            ) {
                recyclerViewHomeStore.also {
                    it.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    it.setHasFixedSize(true)
                    it.adapter = PhoneHomeStoreAdapter(homeStore, requireContext())
                }
                recyclerViewBestSeller.also {
                    it.layoutManager =
                        GridLayoutManager(requireContext(),2)
                    it.adapter = PhoneBestSellerAdapter(bestSeller, requireContext())
                }
            }
        })
    }
}