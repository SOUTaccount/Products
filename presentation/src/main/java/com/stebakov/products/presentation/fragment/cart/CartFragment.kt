package com.stebakov.products.presentation.fragment.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.stebakov.domain.helpers.PriceHelperImpl
import com.stebakov.products.R
import com.stebakov.products.databinding.FragmentCartBinding
import com.stebakov.products.presentation.viewmodel.cart.CartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment(R.layout.fragment_cart) {

    private var viewBinding: FragmentCartBinding? = null
    private val cartViewModel by viewModel<CartViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentCartBinding.bind(view)
        cartViewModel.getCart()
        viewBinding!!.bottomSheetMyCart.rvMyCart.adapter
        cartViewModel.cart.observe(viewLifecycleOwner) { cart ->
            viewBinding?.bottomSheetMyCart?.also {
                it.rvMyCart.adapter = CartAdapter(cart.basket, requireContext())
                it.tvTotalValueMyCart.text = PriceHelperImpl().parsePriceToCart(cart.total)
                it.tvDeliveryValueMyCart.text = cart.delivery
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}