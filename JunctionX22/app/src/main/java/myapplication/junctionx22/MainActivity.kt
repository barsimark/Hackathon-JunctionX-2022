package myapplication.junctionx22

import android.content.Intent
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
import myapplication.junctionx22.databinding.ActivityMainBinding
import myapplication.junctionx22.jar.JarActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

        binding.btnExistingJar.setOnClickListener {
            startActivity(Intent(this, JarActivity::class.java))
        }
        binding.btnAddNewJar.setOnClickListener {
            Toast.makeText(this, "Add new jar button", Toast.LENGTH_LONG).show()
        }

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