package myapplication.junctionx22.jar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import myapplication.junctionx22.databinding.ActivityJarAddBinding.inflate
import myapplication.junctionx22.databinding.ActivityJarBinding.inflate
import myapplication.junctionx22.databinding.ActivityNewJarInfoBinding

class NewJarInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewJarInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewJarInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, NewJarCurrencyActivity::class.java))
            finish()
        }

        /*Glide.with(this)
            .asGif()
            .load(R.raw.christmas_tree)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.tvGif)*/
    }
}