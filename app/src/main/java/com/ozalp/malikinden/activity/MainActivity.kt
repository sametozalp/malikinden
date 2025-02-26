package com.ozalp.malikinden.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ozalp.malikinden.adapter.CategoryAdapter
import com.ozalp.malikinden.databinding.ActivityMainBinding
import com.ozalp.malikinden.util.CategoryItemClickListener
import com.ozalp.malikinden.util.Resource
import com.ozalp.malikinden.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), CategoryItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observeProductLiveData()
        observeProductTypeLiveData()

        viewModel.getProducts()


    }

    private fun observeProductLiveData() {
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

    private fun observeProductTypeLiveData() {
        viewModel.productTypes.observe(this, Observer {
            if(it.isNotEmpty()) {
                categoryAdapter.setCategoryList(it as ArrayList<String>)
            }
        })
    }


    private fun init() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        categoryAdapter = CategoryAdapter(this)
        binding.categoryRecyclerView.adapter = categoryAdapter
    }

    override fun onItemClicked(string: String) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("type", string)
        startActivity(intent)
    }
}