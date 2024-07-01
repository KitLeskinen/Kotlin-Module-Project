class Archive(override val name: String) : Nameble{
    val notes: MutableList<Note> = mutableListOf()
    fun add(note: Note) {
        notes.add(note)
    }

    fun get(index: Int): Note {
        return notes[index]
    }
}