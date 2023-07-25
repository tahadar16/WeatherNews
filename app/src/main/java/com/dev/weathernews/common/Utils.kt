package com.dev.weathernews.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    fun formatTimestampToDateTime(timestamp: Long, pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
            val date = Date(timestamp)
            val sdf = SimpleDateFormat(pattern, Locale.getDefault())
            return sdf.format(date)
    }

    fun kelvinToFarhenheit(kelvin: Double): String {
        val tempFahrenheit =  (kelvin - 273.15) * 9 / 5 + 32
        return String.format("%.2f", tempFahrenheit)
    }
    fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return result
    }
}