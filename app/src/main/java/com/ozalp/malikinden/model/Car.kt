package com.ozalp.malikinden.model

class Car(
    val brand: String,
    val series: String,
    val model: String,
    val year: Int,
    val fuelType: String,
    val gearType: String,
    val carCondition: String,
    val mileage: Int,
    val enginePower: Int,
    val licensePlate: String,
    id: Int,
    type: String,
    userID: Int,
    price: Int,
    date: String,
    description: String,
    location: Location,
    imageIds: List<Int>
) : Product(id, type, userID, price, date, description, location, imageIds)

