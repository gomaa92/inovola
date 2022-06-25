package com.gomaa.inovola.features.writer_details.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.gomaa.inovola.R
import com.gomaa.inovola.base.presentation.view.fragments.BaseFragment
import com.gomaa.inovola.base.utils.Utils
import com.gomaa.inovola.databinding.WrtiterDetailsFragmentBinding
import com.gomaa.inovola.features.list_writer.data.model.ResultsEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriterDetailsFragment :
    BaseFragment<WrtiterDetailsFragmentBinding>(R.layout.wrtiter_details_fragment) {
    private val navArgs: WriterDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateUI(navArgs.writerDetails)

    }

    private fun initiateUI(entity: ResultsEntity) {
        dataBinding.nameTextView.text = entity.name
        dataBinding.priceTextView.append(entity.price)
        Utils.loadImage(requireContext(), dataBinding.writerDetailsImageView, entity.imageUrls[0])
    }
}