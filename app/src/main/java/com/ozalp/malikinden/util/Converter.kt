package com.ozalp.malikinden.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozalp.malikinden.model.Location


class Converter {
    @TypeConverter
    fun fromLocation(location: Location?): String? {
        if (location == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(location)
    }

    @TypeConverter
    fun toLocation(locationString: String?): Location? {
        if (locationString == null) {
            return null
        }
        val gson = Gson()
        return gson.fromJson(locationString, object : TypeToken<Location?>() {}.type)
    }

    @TypeConverter
    fun fromString(value: String?): List<Int> {
        if (value == null || value.isEmpty()) {
            return ArrayList()
        }
        val strings = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val list: MutableList<Int> = ArrayList()
        for (s in strings) {
            list.add(s.trim { it <= ' ' }.toInt())
        }
        return list
    }

    @TypeConverter
    fun fromList(list: List<Int?>?): String {
        if (list == null || list.isEmpty()) {
            return ""
        }
        val stringBuilder = StringBuilder()
        for (i in list.indices) {
            stringBuilder.append(list[i])
            if (i < list.size - 1) {
                stringBuilder.append(",")
            }
        }
        return stringBuilder.toString()
    }
}