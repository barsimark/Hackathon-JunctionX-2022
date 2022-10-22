package myapplication.junctionx22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import myapplication.junctionx22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnExistingJar.setOnClickListener {
            Toast.makeText(this, "Existing jar button", Toast.LENGTH_LONG).show()
        }
        binding.btnAddNewJar.setOnClickListener {
            Toast.makeText(this, "Add new jar button", Toast.LENGTH_LONG).show()
        }
    }
}