package com.ozalp.malikinden.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ozalp.malikinden.model.Product

@Dao
interface ProductDao: BaseDao {

    @Insert
    suspend fun insertAll(vararg productList: Product)

    @Query("select * from product")
    suspend fun getAll(): List<Product>

    @Query("SELECT DISTINCT type FROM product")
    suspend fun getUniqueTypes(): List<String>

    @Query("select * from product where type = :type")
    suspend fun getProductsByType(type: String): List<Product>

    @Query("delete from product")
    suspend fun deleteAll()
}