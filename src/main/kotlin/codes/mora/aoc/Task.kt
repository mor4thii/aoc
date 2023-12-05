package codes.mora.aoc

interface Task<T> {

    val input: List<String>

    fun one(): T

    fun two(): T
}
