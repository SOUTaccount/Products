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
import androidx.room.Room
import com.stebakov.data.cache.Cache
import com.stebakov.data.cache.database.FavoritePhonesDatabase
import com.stebakov.products.R
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.products.presentation.main.App
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import com.stebakov.products.presentation.viewmodel.phone.factory.PhoneViewModelFactory
import com.yarolegovich.discretescrollview.DiscreteScrollView

class PhoneFragment : Fragment() {

    private lateinit var phoneViewModel: PhoneViewModel
    private lateinit var factoryPhone: PhoneViewModelFactory
    private lateinit var discreteScrollViewHomeStore: DiscreteScrollView
    private lateinit var recyclerViewBestSeller: RecyclerView
    private lateinit var navigationView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_fragment, container, false)
        discreteScrollViewHomeStore = view.findViewById(R.id.recyclerview_phone_home_store)
        recyclerViewBestSeller = view.findViewById(R.id.recyclerview_phone_best_seller)
        navigationView = view
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val cache = (requireActivity().application as App).cache
        val phoneCloud = PhoneRepositoryImpl(PhoneService(), cache)
        val model = BasePhoneModel(phoneCloud)
        factoryPhone = PhoneViewModelFactory(model)
        phoneViewModel = ViewModelProvider(this, factoryPhone)[PhoneViewModel::class.java]
        phoneViewModel.getPhone()
        phoneViewModel.addFavoritePhones()
        val favoriteCachePhones = phoneViewModel.getAllFavoritePhones(cache)
        Log.d("CheckDB", "room list = $favoriteCachePhones")
        phoneViewModel.phones.observe(viewLifecycleOwner, Observer { phones ->
            discreteScrollViewHomeStore.also {
                it.setHasFixedSize(true)
                it.adapter = PhoneHomeStoreAdapter(phones, requireContext())
            }
        })
        phoneViewModel.phonesBestSeller.observe(viewLifecycleOwner) { phonesBestSeller ->
            recyclerViewBestSeller.also {
                it.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                it.adapter =
                    PhoneBestSellerAdapter(phonesBestSeller, requireContext(), navigationView)
            }
        }
    }
}