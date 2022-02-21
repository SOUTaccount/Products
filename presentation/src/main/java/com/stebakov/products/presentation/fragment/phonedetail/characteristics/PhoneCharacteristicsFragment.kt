package com.stebakov.products.presentation.fragment.phonedetail.characteristics

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.stebakov.products.R
import com.stebakov.products.databinding.PhoneCharacteristicsFragmentBinding
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhoneCharacteristicsFragment : Fragment(R.layout.phone_characteristics_fragment) {

    private var viewBinding: PhoneCharacteristicsFragmentBinding? = null
    private val detailViewModel by viewModel<DetailViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = PhoneCharacteristicsFragmentBinding.bind(view)
        detailViewModel.getDetail()
        with(viewBinding!!) {
            detailViewModel.phoneDetail.observe(viewLifecycleOwner) { phoneDetail ->
                tvCpu.text = phoneDetail.cpu
                tvCamera.text = phoneDetail.camera
                tvSsd.text = phoneDetail.ssd
                tvSd.text = phoneDetail.sd
                imgFirstColor.setColorFilter(Color.parseColor(phoneDetail.color[0]))
                imgSecondColor.setColorFilter(Color.parseColor(phoneDetail.color[1]))
                btnMinMemory.text = phoneDetail.capacity[0]
                btnMaxMemory.text = phoneDetail.capacity[1]
                btnMinMemory.setOnClickListener {
                    with(btnMinMemory) {
                        setBackgroundColor(resources.getColor(R.color.orange, context.theme))
                        setTextColor(resources.getColor(R.color.white, context.theme))
                    }
                    with(btnMaxMemory) {
                        setBackgroundColor(resources.getColor(R.color.white, context.theme))
                        setTextColor(resources.getColor(R.color.grey, context.theme))
                    }
                }
                btnMaxMemory.setOnClickListener {
                    with(btnMaxMemory) {
                        setBackgroundColor(resources.getColor(R.color.orange, context.theme))
                        setTextColor(resources.getColor(R.color.white, context.theme))
                    }
                    with(btnMinMemory) {
                        setBackgroundColor(resources.getColor(R.color.white, context.theme))
                        setTextColor(resources.getColor(R.color.grey, context.theme))
                    }
                }
                btnAddToCart.text =
                    "${resources.getString(R.string.add_to_cart_text)} ${phoneDetail.price}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}