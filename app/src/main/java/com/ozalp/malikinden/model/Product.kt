package com.ozalp.malikinden.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("product")
open class Product(
    @ColumnInfo()
    val id: Int,
    @ColumnInfo()
    val type: String,
    @ColumnInfo()
    val userID: Int,
    @ColumnInfo()
    val price: Int,
    @ColumnInfo()
    val date: String,
    @ColumnInfo()
    val description: String,
    @ColumnInfo()
    val location: Location,
    @ColumnInfo()
    val imageIds: List<Int>,
) {
    @PrimaryKey(true)
    var uuid: Int = 0
}
