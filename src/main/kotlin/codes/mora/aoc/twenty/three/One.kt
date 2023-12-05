package codes.mora.aoc.twenty.three

import codes.mora.aoc.Task
import codes.mora.aoc.utils.InputDelegate

class One : Task<Int> {
    override val input: List<String> by InputDelegate()

    override fun one() = input.sumOf { it.toInt() }

    override fun two() = input.sumOf { it.toInt() }
}
