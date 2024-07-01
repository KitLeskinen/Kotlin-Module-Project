import java.util.Scanner

abstract class Menu<T : Nameble>(val items: MutableList<T>) {
    fun start() {
        showMenuAndInput()
    }

    abstract val firstItem: String
    abstract val secondItem: String

    abstract fun createItem()
    fun displayMenu(): Int {
        println(firstItem)
        println(secondItem)
        items.forEachIndexed() { index, element ->
            println("${index + 1}. ${element.name}")
        }
        val nextIndex = items.size + 1
        println("$nextIndex. Выход")
        return nextIndex
    }


    abstract fun showItem(index: Int)

    fun showMenuItems(firstItem: (String) -> Unit, secondItem: (String) -> Unit) {
        println("firstItem")
    }

    private fun showMenuAndInput() {
        var input = ""
        var isExit = false
        while (!isExit) {
            val exitIndex = displayMenu()
            input = Scanner(System.`in`).nextLine()
            if (input.toIntOrNull() == null) {
                println("Введите существующую цифру")
                continue
            }
            val index = input.toInt()
            if (index < 0 || index > exitIndex) {
                println("Такой цифры нет")
                continue
            }
            when (index) {
                0 -> createItem()
                in 1..items.size -> showItem(index - 1)
                exitIndex -> isExit = true
            }
        }
    }

    fun validInputAndRun(
        prompt: String,
        error: String,
        result: String,
        action: (String) -> Unit
    ) {
        println(prompt)
        var name = ""
        do {
            name = Scanner(java.lang.System.`in`).nextLine()
            if (name.isEmpty()) {
                println(error)
            }
        } while (name.isEmpty())
        action(name)
        if(!result.isEmpty()){
            println("name $result")
        }
    }
}