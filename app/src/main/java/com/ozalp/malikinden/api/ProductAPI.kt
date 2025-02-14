package com.ozalp.malikinden.api

import com.ozalp.malikinden.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductAPI {

    @GET("product")
    fun getProductById(@Path("id") productId: Int)

    @GET("products")
    fun getProducts(): Single<List<Product>>
}