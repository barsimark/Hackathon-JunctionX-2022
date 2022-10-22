package myapplication.junctionx22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import myapplication.junctionx22.model.CurrencyApiResponse
import myapplication.junctionx22.model.CurrencyConvertion
import myapplication.junctionx22.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertCurrency()
    }

    private fun convertCurrency() {
        NetworkManager.convert("EUR", "USD")?.enqueue(object : Callback<List<CurrencyConvertion?>> {
            override fun onResponse(
                call: Call<List<CurrencyConvertion?>>,
                response: Response<List<CurrencyConvertion?>>
            ) {
                Log.d("TAG", "onResponse: " + response.code())
                Toast.makeText(this@MainActivity, "Message: " + response.body(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(
                call: Call<List<CurrencyConvertion?>>,
                throwable: Throwable
            ) {
                throwable.printStackTrace()
                Toast.makeText(this@MainActivity, "Network request error occured, check LOG", Toast.LENGTH_LONG).show()
            }
        })
    }
}