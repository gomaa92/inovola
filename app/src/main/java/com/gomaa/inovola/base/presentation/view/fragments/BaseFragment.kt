package com.gomaa.inovola.base.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class BaseFragment<DataBinding : ViewDataBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {
    private var internalDataBinding: DataBinding? = null
    protected val dataBinding: DataBinding
        get() {
            return internalDataBinding ?: throw IllegalStateException(
                "data binding should not be requested before onViewCreated is called"
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ViewModel is set as Binding Variable
        internalDataBinding = DataBindingUtil.bind<DataBinding>(view)?.apply {
            lifecycleOwner = this@BaseFragment
        }
    }
}