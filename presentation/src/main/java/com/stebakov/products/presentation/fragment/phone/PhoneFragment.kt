package com.stebakov.products.presentation.fragment.phone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.stebakov.products.R
import com.stebakov.products.databinding.PhoneFragmentBinding
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneFragment : Fragment(R.layout.phone_fragment) {

    private var viewBinding: PhoneFragmentBinding? = null
    private val phoneViewModel by viewModel<PhoneViewModel>()
    private lateinit var navigationView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = PhoneFragmentBinding.bind(view)
        navigationView = view
        phoneViewModel.getPhone()
        phoneViewModel.addFavoritePhones()
        viewBinding!!.llPhonesMain.visibility = View.GONE
        viewBinding!!.loadingIndicator.visibility = View.VISIBLE
        phoneViewModel.phones.observe(viewLifecycleOwner) { phones ->
            viewBinding!!.recyclerviewPhoneHomeStore.also {
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
        }
        phoneViewModel.phonesBestSeller.observe(viewLifecycleOwner) { phonesBestSeller ->
            viewBinding!!.recyclerviewPhoneBestSeller.also {
                it.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                it.adapter =
                    PhoneBestSellerAdapter(phonesBestSeller, requireContext(), navigationView)
            }
            if (!phonesBestSeller.isNullOrEmpty()){
                with(viewBinding!!){
                    llPhonesMain.visibility = View.VISIBLE
                    loadingIndicator.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}