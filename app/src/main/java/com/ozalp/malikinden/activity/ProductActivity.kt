package com.ozalp.malikinden.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.ozalp.malikinden.R
import com.ozalp.malikinden.adapter.CategorySelectionAdapter
import com.ozalp.malikinden.databinding.ActivityProductBinding
import com.ozalp.malikinden.fragment.ProductListFragment
import com.ozalp.malikinden.fragment.ProductListFragmentDirections
import com.ozalp.malikinden.model.Product
import com.ozalp.malikinden.util.SharedPreferencesUtil
import com.ozalp.malikinden.viewmodel.ProductActivityViewModel

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("type")

        val sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this)
        type?.let { sharedPreferencesUtil.saveProductType(it) }


    }

}