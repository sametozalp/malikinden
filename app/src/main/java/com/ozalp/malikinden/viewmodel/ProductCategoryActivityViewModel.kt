package com.ozalp.malikinden.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ozalp.malikinden.R
import com.ozalp.malikinden.database.MalikindenDatabase
import com.ozalp.malikinden.model.Product
import com.ozalp.malikinden.service.ProductService
import com.ozalp.malikinden.util.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ProductCategoryActivityViewModel(application: Application): BaseViewModel(application) {

    val products = MutableLiveData<Resource<List<Product>>>()
    private val disposable = CompositeDisposable()

    fun getProducts() {
        val service = ProductService()
        products.value = Resource.Loading(true)

        disposable.add(
            service.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Product>>() {
                    override fun onSuccess(t: List<Product>) {
                        products.value = Resource.Success(t)
                        products.value = Resource.Loading(false)
                    }

                    override fun onError(e: Throwable) {
                        products.value = Resource.Error(e.message ?: getApplication<Application>().getString(
                            R.string.unknown_error), e)
                        products.value = Resource.Loading(false)
                    }
                })
        )
    }

    fun storeInSQLDatabase(l: List<Product>) {
        launch {
            val productDao = MalikindenDatabase(getApplication()).productDao()

            productDao.insertAll(*l.toTypedArray())

            val allProducts = productDao.getAll()

            allProducts.forEach { product ->
                println("Product ID: ${product.id}, Name: ${product.description}, Location: ${product.location}")
            }
        }
    }

}