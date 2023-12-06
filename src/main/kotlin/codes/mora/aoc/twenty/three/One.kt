package codes.mora.aoc.twenty.three

import codes.mora.aoc.Task
import codes.mora.aoc.utils.InputDelegate

class One : Task<Int> {
    override val input: List<String> by InputDelegate()

    override fun one() = input
        .map { it.filter { c -> c.isDigit() } }
        .filter { it.isNotBlank() }
        .mapNotNull { "${it.first()}${it.last()}".toIntOrNull() }
        .sumOf { it }

    override fun two() = input.sumOf { it.toInt() }
}
