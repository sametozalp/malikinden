package com.ozalp.malikinden.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ozalp.malikinden.R
import com.ozalp.malikinden.databinding.ActivityProductCategoryBinding
import com.ozalp.malikinden.util.Resource
import com.ozalp.malikinden.viewmodel.ProductCategoryActivityViewModel

class ProductCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductCategoryBinding
    private lateinit var viewModel: ProductCategoryActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observeLiveData()

        viewModel.getProducts()


    }

    private fun observeLiveData() {
        viewModel.products.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    viewModel.storeInSQLDatabase(it.data)
                }
                is Resource.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                is Resource.Loading -> {
                    // Yükleniyor durumunu göster
                }
            }
        })
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(ProductCategoryActivityViewModel::class.java)
    }
}