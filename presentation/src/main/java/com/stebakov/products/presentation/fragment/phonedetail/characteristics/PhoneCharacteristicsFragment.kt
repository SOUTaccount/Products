package com.stebakov.products.presentation.fragment.phonedetail.characteristics

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.stebakov.products.R
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhoneCharacteristicsFragment : Fragment() {
    private lateinit var cpu: TextView
    private lateinit var camera: TextView
    private lateinit var ssd: TextView
    private lateinit var sd: TextView
    private lateinit var imgBtnFirstColor: ImageView
    private lateinit var imgBtnSecondColor: ImageView
    private lateinit var btnMinMemory: Button
    private lateinit var btnMaxMemory: Button
    private lateinit var btnAddToCart: Button
    private val detailViewModel by viewModel<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_characteristics_fragment, container, false)
        cpu = view.findViewById(R.id.tv_cpu)
        camera = view.findViewById(R.id.tv_camera)
        ssd = view.findViewById(R.id.tv_ssd)
        sd = view.findViewById(R.id.tv_sd)
        imgBtnFirstColor = view.findViewById(R.id.img_first_color)
        imgBtnSecondColor = view.findViewById(R.id.img_second_color)
        btnMinMemory = view.findViewById(R.id.btn_min_memory)
        btnMaxMemory = view.findViewById(R.id.btn_max_memory)
        btnAddToCart = view.findViewById(R.id.btn_add_to_cart)
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailViewModel.getDetail()
        detailViewModel.phoneDetail.observe(viewLifecycleOwner, Observer { phoneDetail ->
            cpu.text = phoneDetail.cpu
            camera.text = phoneDetail.camera
            ssd.text = phoneDetail.ssd
            sd.text = phoneDetail.sd
            imgBtnFirstColor.setColorFilter(Color.parseColor(phoneDetail.color[0]))
            imgBtnSecondColor.setColorFilter(Color.parseColor(phoneDetail.color[1]))
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
        })
    }
}