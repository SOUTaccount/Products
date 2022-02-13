package com.stebakov.products.presentation.fragment.phonedetail.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.stebakov.data.cache.Cache
import com.stebakov.data.cache.database.FavoritePhonesDatabase
import com.stebakov.products.R
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Details
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Features
import com.stebakov.products.presentation.viewmodel.detail.BaseDetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import com.stebakov.products.presentation.viewmodel.detail.factory.DetailViewModelFactory
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.FragmentCharacteristicsAdapter
import com.stebakov.products.presentation.fragment.phonedetail.characteristics.Shop
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer


class PhoneDetailFragment : Fragment() {
    private lateinit var recyclerViewImage: DiscreteScrollView
    private lateinit var ivCart: ImageView
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var factory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel
    private lateinit var phoneName: TextView
    private val characteristics = listOf(Shop, Details, Features)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.phone_detail_fragment, container, false)
        recyclerViewImage = view.findViewById(R.id.rv_image_phone_product_details)
        ivCart = view.findViewById(R.id.iv_cart_container_product_details)
        viewPager = view.findViewById(R.id.viewpager_detail)
        tabLayout = view.findViewById(R.id.tab_detail)
        phoneName = view.findViewById(R.id.tv_phone_name_detail)
        val adapter = FragmentCharacteristicsAdapter(requireActivity(), characteristics)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = characteristics[position].name
        }.attach()
        ivCart.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_phoneDetailFragment_to_cartFragment)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val database = Room.databaseBuilder(
            requireContext(),
            FavoritePhonesDatabase::class.java,
            "FavoritePhone"
        ).build()
        val cache = Cache(database.favoritePhonesDao())
        val phoneCloud = PhoneRepositoryImpl(PhoneService(), cache)
        val model = BaseDetailModel(phoneCloud)
        factory = DetailViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        viewModel.getDetail()
        viewModel.phoneDetail.observe(viewLifecycleOwner, Observer { phoneDetail ->
            recyclerViewImage.also {
                it.setItemTransformer(
                    ScaleTransformer.Builder()
                        .setMaxScale(1.0f)
                        .setMinScale(0.3f)
                        .setPivotX(Pivot.X.CENTER)
                        .setPivotY(Pivot.Y.CENTER)
                        .build()
                )
                it.adapter = ImageDetailAdapter(phoneDetail, requireContext())
                phoneName.text = phoneDetail.title
            }
        })
    }
}