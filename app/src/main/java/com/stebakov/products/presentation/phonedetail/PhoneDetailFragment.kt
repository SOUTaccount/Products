package com.stebakov.products.presentation.phonedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R


class PhoneDetailFragment : Fragment() {
    private lateinit var recyclerViewImage: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_detail_fragment, container, false)
        recyclerViewImage = view.findViewById(R.id.rv_image_phone_detail)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}