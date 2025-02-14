package com.ozalp.malikinden.model

class Home(
    val realEstateType: String,
    val grossArea: Int,
    val netArea: Int,
    val roomCount: String,
    val buildingAge: Int,
    val floor: Int,
    val totalFloors: Int,
    val heating: String,
    val bathroomCount: Int,
    val kitchen: String,
    val balcony: Boolean,
    val elevator: Boolean,
    val parking: Boolean,
    val furnished: Boolean,
    id: Int,
    type: String,
    userID: Int,
    price: Int,
    date: String,
    description: String,
    location: Location,
    imageIds: List<Int>
) : Product(id, type, userID, price, date, description, location, imageIds)