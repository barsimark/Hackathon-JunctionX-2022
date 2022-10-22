package myapplication.junctionx22.jar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import myapplication.junctionx22.databinding.ItemJarListBinding
import myapplication.junctionx22.model.JarItem

class JarAdapter: RecyclerView.Adapter<JarAdapter.JarViewHolder>() {
    private val items: MutableList<JarItem> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JarViewHolder (
        ItemJarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: JarViewHolder, position: Int) {
        val jarItem = items[position]

        holder.binding.tvTitle.text = jarItem.title
        holder.binding.tvMoney.text = jarItem.sum.toString()
    }

    fun addItem(item: JarItem){
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    inner class JarViewHolder(val binding: ItemJarListBinding) : RecyclerView.ViewHolder(binding.root)
}