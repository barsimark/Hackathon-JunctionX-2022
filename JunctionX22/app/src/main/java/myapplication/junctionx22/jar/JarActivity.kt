package myapplication.junctionx22.jar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityJarBinding
import myapplication.junctionx22.model.JarItem
import myapplication.junctionx22.model.JarItemManager
import kotlin.concurrent.thread


class JarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJarBinding
    private lateinit var adapter: JarAdapter

    private var animate = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, JarAddActivity::class.java))
        }

        binding.btnWithdraw.setOnClickListener {
            JarItemManager.addItem(JarItem("Withdrawal", -2000))
            adapter.updateAll(JarItemManager.getItems())
            animateDown()
        }
    }

    override fun onResume() {
        super.onResume()

        initRecyclerView()
        animateUp()
    }

    private fun initRecyclerView(){
        adapter = JarAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        adapter.updateAll(JarItemManager.getItems())
    }

    private fun animateUp(){
        loadGifUp(animate)
        thread {
            Thread.sleep(1700)
            runOnUiThread(){
                loadGifUp(animate)
            }
        }
    }

    private fun animateDown(){
        loadGifDown(animate)
        thread {
            Thread.sleep(1500)
            runOnUiThread(){
                loadGifDown(animate)
            }
        }
    }

    private fun loadGifUp(toAnimate: Boolean){
        animate = if (toAnimate){
            Glide.with(this)
                .asGif()
                .load(R.raw.tree_from_zero_to_max)
                .into(binding.gifImageView)

            false
        } else {
            Glide.with(this)
                .asGif()
                .load(R.raw.full_tree)
                .into(binding.gifImageView)

            true
        }
    }

    private fun loadGifDown(toAnimate: Boolean){
        animate = if (toAnimate){
            Glide.with(this)
                .asGif()
                .load(R.raw.tree_from_max_back_to_zero)
                .into(binding.gifImageView)

            false
        } else {
            Glide.with(this)
                .asGif()
                .load(R.raw.zero_tree)
                .into(binding.gifImageView)

            true
        }
    }
}