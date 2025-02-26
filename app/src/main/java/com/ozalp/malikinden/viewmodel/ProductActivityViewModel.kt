package com.ozalp.malikinden.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ozalp.malikinden.database.MalikindenDatabase
import com.ozalp.malikinden.model.Product
import kotlinx.coroutines.launch

class ProductActivityViewModel(application: Application) : BaseViewModel(application) {

    val productList = MutableLiveData<List<Product>>()

    fun getProductWithType(type: String) {
        launch {
            val productDao = MalikindenDatabase(getApplication()).productDao()
            productList.postValue(productDao.getProductsByType(type))
        }
    }

}