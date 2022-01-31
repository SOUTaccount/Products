package com.stebakov.products.presentation.fragment.phonedetail.characteristics

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stebakov.products.R
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.products.presentation.viewmodel.detail.BaseDetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import com.stebakov.products.presentation.viewmodel.detail.factory.DetailViewModelFactory


class PhoneCharacteristicsFragment : Fragment() {
    private lateinit var cpu: TextView
    private lateinit var camera: TextView
    private lateinit var ssd: TextView
    private lateinit var sd: TextView
    private lateinit var imgBtnFirstColor: ImageButton
    private lateinit var imgBtnSecondColor: ImageButton
    private lateinit var btnMinMemory: Button
    private lateinit var btnMaxMemory: Button
    private lateinit var btnAddToCart: Button
    private lateinit var viewModel: DetailViewModel
    private lateinit var factory: DetailViewModelFactory

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
        val phoneCloud = PhoneRepositoryImpl(PhoneService())
        val model = BaseDetailModel(phoneCloud)
        factory = DetailViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        viewModel.getDetail()
        viewModel.phoneDetail.observe(viewLifecycleOwner, Observer { phoneDetail ->
            cpu.text = phoneDetail.cpu
            camera.text = phoneDetail.camera
            ssd.text = phoneDetail.ssd
            sd.text = phoneDetail.sd
            imgBtnFirstColor.setBackgroundColor(Color.parseColor(phoneDetail.color[0]))
            imgBtnSecondColor.setBackgroundColor(Color.parseColor(phoneDetail.color[1]))
            btnMinMemory.text = phoneDetail.capacity[0]
            btnMaxMemory.text = phoneDetail.capacity[1]
            btnAddToCart.text = "${resources.getString(R.string.add_to_cart_text)} ${phoneDetail.price}"
        })
    }

}