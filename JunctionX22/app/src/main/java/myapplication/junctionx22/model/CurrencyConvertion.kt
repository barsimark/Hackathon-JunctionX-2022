package myapplication.junctionx22.model

import com.google.gson.annotations.SerializedName

data class CurrencyConvertion(
    /*var rate: Float,
    var source: String,
    var target: String,
    var time: String*/
    @SerializedName("rate") val rate : Double,
    @SerializedName("source") val source : String,
    @SerializedName("target") val target : String,
    @SerializedName("time") val time : String
)