package myapplication.junctionx22.jar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityNewJarCategoryBinding

class NewJarCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewJarCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewJarCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlant.setOnClickListener {
            startActivity(Intent(this, NewJarCurrencyActivity::class.java))
            finish()
        }
    }
}