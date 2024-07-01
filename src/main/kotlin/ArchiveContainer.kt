class ArchiveContainer {
    val archives: MutableList<Archive> = mutableListOf()
    fun add(archive: Archive) {
        archives.add(archive)
    }
}