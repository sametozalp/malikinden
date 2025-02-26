package com.ozalp.malikinden.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.ozalp.malikinden.R
import com.ozalp.malikinden.adapter.CategorySelectionAdapter
import com.ozalp.malikinden.databinding.FragmentProductListBinding
import com.ozalp.malikinden.model.Product
import com.ozalp.malikinden.util.SharedPreferencesUtil
import com.ozalp.malikinden.viewmodel.ProductActivityViewModel

class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductActivityViewModel
    private lateinit var categorySelectionAdapter: CategorySelectionAdapter
    private lateinit var binding: FragmentProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        val sharedPreferencesUtil = SharedPreferencesUtil.getInstance(requireContext())
        val type = sharedPreferencesUtil.getProductType()
        type?.let { getProductWithType(it) }

        observeProductLiveData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun observeProductLiveData() {
        viewModel.productList.observe(this, Observer {
            if(it.isNotEmpty()) {
                categorySelectionAdapter.setCategorySelectionList(it as ArrayList<Product>)
            }
        })
    }

    private fun getProductWithType(type: String) {
        viewModel.getProductWithType(type)
    }

    private fun init() {
        binding = FragmentProductListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ProductActivityViewModel::class.java)
        categorySelectionAdapter = CategorySelectionAdapter()
        binding.categoryRecyclerView.adapter = categorySelectionAdapter

    }
}