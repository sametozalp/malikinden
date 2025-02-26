package com.ozalp.malikinden.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ozalp.malikinden.model.Location

class BindingAdapterUtil {

    companion object {

        @JvmStatic
        @BindingAdapter("locationText")
        fun setLocationText(view: TextView, location: Location) {
            view.text = "longitude: ${location.longitude}, latitude: ${location.latitude}"
        }

        @JvmStatic
        @BindingAdapter("priceText")
        fun setPriceText(view: TextView, int: Int) {
            view.text = "${int} TL"
        }

    }
}