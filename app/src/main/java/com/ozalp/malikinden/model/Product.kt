package com.ozalp.malikinden.model

open class Product(
    val id: Int,
    val type: String,
    val userID: Int,
    val price: Int,
    val date: String,
    val description: String,
    val location: Location,
    val imageIds: List<Int>,
)
