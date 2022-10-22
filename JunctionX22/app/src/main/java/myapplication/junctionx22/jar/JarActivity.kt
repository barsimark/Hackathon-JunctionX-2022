package myapplication.junctionx22.jar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ActivityJarBinding
import myapplication.junctionx22.model.JarItem

class JarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJarBinding
    private lateinit var adapter: JarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, JarAddActivity::class.java))
        }

        initRecyclerView()
    }

    fun initRecyclerView(){
        adapter = JarAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        adapter.addItem(JarItem("Add money directly", 10000))
        adapter.addItem(JarItem("Purchase percentage", 145))
        adapter.addItem(JarItem("Recurring transfer", 1000))
    }
}