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

}