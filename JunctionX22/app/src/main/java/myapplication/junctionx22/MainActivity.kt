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
import myapplication.junctionx22.jar.DiscountDialogFragment
import myapplication.junctionx22.jar.JarActivity
import myapplication.junctionx22.jar.NewJarCategoryActivity
import myapplication.junctionx22.model.Globals
import myapplication.junctionx22.model.JarItemManager

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
            startActivity(Intent(this, NewJarCategoryActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        binding.tvName.text = Globals.getJarName()
        binding.tvSum.text = JarItemManager.getSum().toString()
    }
}