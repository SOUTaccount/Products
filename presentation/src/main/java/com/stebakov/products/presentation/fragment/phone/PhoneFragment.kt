package com.stebakov.products.presentation.fragment.phone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneFragment : Fragment() {

    private val phoneViewModel by viewModel<PhoneViewModel>()
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
        phoneViewModel.getPhone()
        phoneViewModel.addFavoritePhones()
        phoneViewModel.phones.observe(viewLifecycleOwner, Observer { phones ->
            discreteScrollViewHomeStore.also {
                it.setHasFixedSize(true)
                it.setItemTransformer(
                    ScaleTransformer.Builder()
                        .setMaxScale(1.05f)
                        .setMinScale(0.8f)
                        .setPivotX(Pivot.X.CENTER)
                        .setPivotY(Pivot.Y.BOTTOM)
                        .build()
                )
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