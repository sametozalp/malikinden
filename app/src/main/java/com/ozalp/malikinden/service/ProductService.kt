package com.ozalp.malikinden.service

import com.ozalp.malikinden.api.ProductAPI
import com.ozalp.malikinden.model.Product
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ProductService: BaseService() {

    private val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductAPI::class.java)

    fun getProducts(): Single<List<Product>> {
        return service.getProducts()
    }
}