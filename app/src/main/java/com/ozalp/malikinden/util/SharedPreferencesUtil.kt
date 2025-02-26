package com.ozalp.malikinden.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPreferencesUtil() {


    private val TYPE = "type"

    companion object {

        private var sharedPreferences: SharedPreferences? = null
        private var instance: SharedPreferencesUtil? = null

        @Synchronized
        fun getInstance(context: Context): SharedPreferencesUtil {
            if(instance == null) {
                sharedPreferences = context.getSharedPreferences("com.ozalp.malikinden", MODE_PRIVATE)
                instance = SharedPreferencesUtil()
                return instance as SharedPreferencesUtil
            } else {
                return instance!!
            }
        }

    }

    fun saveProductType(type: String) {
        sharedPreferences?.edit()?.putString(TYPE, type)?.apply()
    }

    fun getProductType(): String? {
        return sharedPreferences?.getString(TYPE, "")
    }
}