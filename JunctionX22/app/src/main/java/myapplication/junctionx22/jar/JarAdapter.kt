package myapplication.junctionx22.jar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import myapplication.junctionx22.R
import myapplication.junctionx22.databinding.ItemJarListBinding
import myapplication.junctionx22.model.JarItem

class JarAdapter: RecyclerView.Adapter<JarAdapter.JarViewHolder>() {
    private var items: MutableList<JarItem> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JarViewHolder (
        ItemJarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: JarViewHolder, position: Int) {
        val jarItem = items[position]

        holder.binding.tvTitle.text = jarItem.title
        holder.binding.tvMoney.text = jarItem.sum.toString()

        holder.binding.ivIcon.setImageResource(
            when (jarItem.title){
                "Add money directly" -> R.drawable.add_money_directly
                else -> R.drawable.card_transaction
            }
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAll(new_items: MutableList<JarItem>){
        items = new_items
        notifyDataSetChanged()
    }

    inner class JarViewHolder(val binding: ItemJarListBinding) : RecyclerView.ViewHolder(binding.root)
}