package myapplication.junctionx22.network

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private val retrofit: Retrofit
    private val currencyApi: CurrencyApi

    private const val SERVICE_URL = "https://api.sandbox.transferwise.tech"
    private const val APP_ID = "d6617f23-e575-4886-a7d0-3ee2d0c4921c"

    init {
        val client =  OkHttpClient.Builder()
            .addInterceptor(OAuthInterceptor("Bearer", APP_ID))
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        currencyApi = retrofit.create(CurrencyApi::class.java)
    }

    fun convert(source: String?, target: String?): Call<CurrencyApi?>? {
        return currencyApi.convert(source, target)
    }
}