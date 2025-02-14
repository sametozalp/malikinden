package com.ozalp.malikinden.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {

    @GET("user/{userId}")
    suspend fun getUserById(@Path("id") userId: Int)
}