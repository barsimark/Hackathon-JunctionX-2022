package myapplication.junctionx22.model

object Globals {
    private var jarName: String = "The"
    private var target: Int = 350000

    fun setJarName(name: String){
        jarName = name
    }

    fun getJarName(): String = jarName

    fun getTarget(): Int = target
}