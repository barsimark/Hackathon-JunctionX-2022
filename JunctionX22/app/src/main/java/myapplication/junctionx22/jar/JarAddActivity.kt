package myapplication.junctionx22.jar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityJarAddBinding
import myapplication.junctionx22.model.CurrencyConvertion
import myapplication.junctionx22.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JarAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJarAddBinding
    private lateinit var convertion: CurrencyConvertion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJarAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        convertCurrency("EUR", "USD")
    }

    private fun convertCurrency(source: String, target: String) {
        NetworkManager.convert(source, target)?.enqueue(object : Callback<List<CurrencyConvertion?>> {
            override fun onResponse(
                call: Call<List<CurrencyConvertion?>>,
                response: Response<List<CurrencyConvertion?>>
            ) {
                Log.d("TAG", "onResponse: " + response.code())
                convertion = response.body()?.get(0)!!
                Toast.makeText(this@JarAddActivity, "Message: " + convertion.rate, Toast.LENGTH_LONG).show()
            }

            override fun onFailure(
                call: Call<List<CurrencyConvertion?>>,
                throwable: Throwable
            ) {
                throwable.printStackTrace()
                Toast.makeText(this@JarAddActivity, "Network request error occured, check LOG", Toast.LENGTH_LONG).show()
            }
        })
    }
}