package com.stebakov.products.presentation.fragment.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.domain.helpers.PriceHelper
import com.stebakov.products.R
import com.stebakov.products.databinding.FragmentCartBinding
import com.stebakov.products.presentation.fragment.phone.PhoneHomeStoreAdapter
import com.stebakov.products.presentation.main.App
import com.stebakov.products.presentation.viewmodel.cart.BaseCartModel
import com.stebakov.products.presentation.viewmodel.cart.CartViewModel
import com.stebakov.products.presentation.viewmodel.cart.factory.CartViewModelFactory
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import com.stebakov.products.presentation.viewmodel.phone.factory.PhoneViewModelFactory
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

class CartFragment : Fragment(R.layout.fragment_cart) {

    private var viewBinding: FragmentCartBinding? = null
    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartViewModelFactory: CartViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentCartBinding.bind(view)
        val cache = (requireActivity().application as App).cache
        val phoneCloud = PhoneRepositoryImpl(PhoneService(), cache)
        val model = BaseCartModel(phoneCloud)
        cartViewModelFactory = CartViewModelFactory(model)
        cartViewModel = ViewModelProvider(this, cartViewModelFactory)[CartViewModel::class.java]
        cartViewModel.getCart()
        viewBinding!!.bottomSheetMyCart.rvMyCart.adapter
        cartViewModel.cart.observe(viewLifecycleOwner, Observer { cart ->
            viewBinding?.bottomSheetMyCart?.also {
                it.rvMyCart.adapter = CartAdapter(cart.basket,requireContext())
                it.tvTotalValueMyCart.text = PriceHelper().parsePriceToCart(cart.total)
                it.tvDeliveryValueMyCart.text = cart.delivery
            }
        })
    }

}