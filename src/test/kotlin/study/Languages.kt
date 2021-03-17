package study

class Languages {
    private val languages: MutableList<Language> = mutableListOf()

    infix fun String.level(level: Int) {
        languages.add(Language(this, level))
    }

    fun toList(): List<Language> = languages.toList()
}

fun languages(initializer: Languages.() -> Unit): Languages {
    return Languages().apply(initializer)
}