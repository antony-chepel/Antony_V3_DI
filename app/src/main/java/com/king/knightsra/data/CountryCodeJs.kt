package com.king.knightsra.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CountryCodeJS(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("countryCode")
    val countryCode: String,
)
