package com.example.beelineproject.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

open class BaseFragment<viewModel: BaseVM, viewBinding: ViewBinding>(
    private val vmClass: Class<viewModel>,
    //inline val bindingCreator: (inflater: LayoutInflater) -> viewBinding
): Fragment() {

    protected lateinit var viewModel: viewModel

//    private var _binding: viewBinding? = null
//    protected val binding: viewBinding
//        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[vmClass]
    }

}