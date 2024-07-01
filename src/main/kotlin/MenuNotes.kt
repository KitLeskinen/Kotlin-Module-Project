

class MenuNotes(val currentArchive: Archive) : Menu<Note>(currentArchive.notes) {

    override val firstItem = "Список заметок:"
    override val secondItem = "0. Создать заметку"


    override fun createItem() {

        var noteName = ""
        var noteContent = ""

        validInputAndRun(
            "Введите имя заметки:",
            "Имя может не быть пустым",
            ""
        ) { name ->
            noteName = name
        }

        validInputAndRun(
            "Введите содержимое заметки:",
            "Содержимое не может быть пустым",
            ""
        ) { name ->
            noteContent = name
        }

        val note = Note(noteName, noteContent)
        currentArchive.add(note)
        println("${note.name} заметка создана")
    }

    override fun showItem(index: Int) {
        println("Заметка: ${items[index].name}:")
        println(items[index].content)
    }
}