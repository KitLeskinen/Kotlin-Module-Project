

class MenuArchive(val archiveContainer: ArchiveContainer) :
    Menu<Archive>(archiveContainer.archives) {

    override val firstItem = "Список архивов:"
    override val secondItem = "0. Создать архив"


    override fun createItem() {
        validInputAndRun(
            "Введите имя архива:",
            "Имя архива не может быть пустым",
            "архив создан"
        ) { input ->
            val archive = Archive(input)
            archiveContainer.add(archive)
        }
    }

    override fun showItem(index: Int) {
        MenuNotes(items[index]).start()
    }
}