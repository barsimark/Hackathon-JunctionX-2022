package myapplication.junctionx22.jar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityNewJarCurrencyBinding

class NewJarCurrencyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewJarCurrencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewJarCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHUF.setOnClickListener {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_LONG).show()
        }

        binding.btnJPY.setOnClickListener {
            startActivity(Intent(this, NewJarSettingsActivity::class.java))
            finish()
        }
    }
}