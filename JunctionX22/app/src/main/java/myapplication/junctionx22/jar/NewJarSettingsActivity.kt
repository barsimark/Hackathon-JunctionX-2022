package myapplication.junctionx22.jar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import myapplication.junctionx22.MyApplication
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityNewJarSettingsBinding
import myapplication.junctionx22.model.Globals

class NewJarSettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewJarSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewJarSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            Globals.setJarName(binding.etInput.text.toString())
            startActivity(Intent(this, JarActivity::class.java))
            finish()
        }
    }
}