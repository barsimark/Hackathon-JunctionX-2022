package myapplication.junctionx22.model

object JarItemManager {
    private val items: MutableList<JarItem> = arrayListOf(
        JarItem("Add money directly", 10000),
        JarItem("Purchase percentage", 145),
        JarItem("Recurring transfer", 1000)
    )

    fun addItem(item: JarItem){
        items.add(item)
    }

    fun getItems(): MutableList<JarItem> {
        val reversed: MutableList<JarItem> = items.reversed().toMutableList()
        return reversed
    }
}