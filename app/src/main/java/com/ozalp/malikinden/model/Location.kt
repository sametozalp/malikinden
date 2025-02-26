package com.ozalp.malikinden.model

data class Location(
    val latitude: Double,
    val longitude: Double
) {
    override fun toString(): String {

        return "latitude: ${latitude}, longitude: ${longitude}"

    }
}
