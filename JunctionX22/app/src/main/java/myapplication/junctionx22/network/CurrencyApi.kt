package myapplication.junctionx22.network

import myapplication.junctionx22.model.CurrencyApiResponse
import myapplication.junctionx22.model.CurrencyConvertion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("/v1/rates")
    fun convert(
        @Query("source") source: String?,
        @Query("target") target: String?
    ): Call<List<CurrencyConvertion?>>?
}