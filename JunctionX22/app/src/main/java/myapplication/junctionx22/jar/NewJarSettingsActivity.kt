package myapplication.junctionx22.jar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityNewJarSettingsBinding

class NewJarSettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewJarSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewJarSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etInput.doAfterTextChanged {
            if (binding.etInput.text.isEmpty()){
                binding.tvInput.text = "PlanT"
            }
            else {
                binding.tvInput.text = binding.etInput.text
            }
        }
        binding.btnConfirm.setOnClickListener {
            startActivity(Intent(this, JarActivity::class.java))
            finish()
        }
    }
}