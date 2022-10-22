package myapplication.junctionx22.jar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityJarAddBinding
import myapplication.junctionx22.model.CurrencyConvertion
import myapplication.junctionx22.model.JarItem
import myapplication.junctionx22.model.JarItemManager
import myapplication.junctionx22.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JarAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJarAddBinding
    private lateinit var convertion: CurrencyConvertion
    private var isValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJarAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        convertCurrency("HUF", "JPY")
        fillTextViews()

        binding.etInput.doAfterTextChanged {
            fillTextViews()
        }

        binding.btnAddToJar.setOnClickListener {
            JarItemManager.addItem(
                JarItem("Add money directly",
                    (binding.etInput.text.toString().toInt() * convertion.rate).toInt()))

            finish()
        }
    }

    private fun fillTextViews(){
        if (binding.etInput.text.isNotEmpty()) {
            val inputValue = binding.etInput.text.toString().toInt()

            binding.tvInput.text = inputValue.toString()
            if (isValid) {
                binding.tvConvRate.text = convertion.rate.toString()
                binding.tvResult.text = (inputValue * convertion.rate).toString()
            }
        }
    }

    private fun convertCurrency(source: String, target: String) {
        NetworkManager.convert(source, target)?.enqueue(object : Callback<List<CurrencyConvertion?>> {
            override fun onResponse(
                call: Call<List<CurrencyConvertion?>>,
                response: Response<List<CurrencyConvertion?>>
            ) {
                Log.d("TAG", "onResponse: " + response.code())
                convertion = response.body()?.get(0)!!
                isValid = true
                binding.btnAddToJar.isEnabled = true
                fillTextViews()
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