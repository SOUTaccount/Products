package com.stebakov.products.presentation.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stebakov.products.R
import com.stebakov.products.databinding.FragmentFavoritePhonesBinding
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritePhonesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritePhonesFragment : Fragment(R.layout.fragment_favorite_phones) {

    private lateinit var viewBinding: FragmentFavoritePhonesBinding
    private val phoneViewModel by viewModel<PhoneViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentFavoritePhonesBinding.bind(view)
        phoneViewModel.getAllFavoritePhones()
        viewBinding.rvFavoritePhones.also {
            phoneViewModel.favoritePhones.observe(viewLifecycleOwner) {listFavoritePhones ->
                it.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
                it.adapter = FavoritePhonesAdapter(listFavoritePhones)
            }
        }
    }
}