package com.gomaa.inovola.features.list_writer.presentation.writers.view.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gomaa.inovola.R
import com.gomaa.inovola.base.presentation.view.fragments.BaseFragment
import com.gomaa.inovola.base.utils.Utils
import com.gomaa.inovola.databinding.WritersFragmentBinding
import com.gomaa.inovola.features.list_writer.data.model.ResultsEntity
import com.gomaa.inovola.features.list_writer.presentation.writers.listener.ShowItemDetailsListener
import com.gomaa.inovola.features.list_writer.presentation.writers.view.adapter.WriterListAdapter
import com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel.WritersListActions
import com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel.WritersListViewModel
import com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel.WritersListViewState
import dagger.hilt.android.AndroidEntryPoint

const val WRITER_DETAILS_EXTRA = "writer_details"

@AndroidEntryPoint
class WriterListFragment : BaseFragment<WritersFragmentBinding>(R.layout.writers_fragment),
    ShowItemDetailsListener {
    val viewModel: WritersListViewModel by viewModels()

    private lateinit var adapter: WriterListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dispatch(WritersListActions.GetWritersList)
        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        adapter = WriterListAdapter(this)
        dataBinding.writersRecyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                WritersListViewState.Failure -> {
                    hideLoading()
                    Utils.Alert(
                        requireContext(),
                        getString(R.string.error_title),
                        getString(R.string.error_desc)
                    )
                }

                is WritersListViewState.Loading -> showLoading()
                is WritersListViewState.Success -> {
                    hideLoading()
                    adapter.setItems(it.response?.results)
                }
            }
        }
    }

    private fun showLoading() {
        dataBinding.writersProgressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        dataBinding.writersProgressBar.visibility = View.GONE
    }

    override fun onItemClickedListener(item: ResultsEntity) {
        val bundle = bundleOf(WRITER_DETAILS_EXTRA to item)
        view?.findNavController()?.navigate(R.id.writerDetailsFragment, bundle)

    }
}