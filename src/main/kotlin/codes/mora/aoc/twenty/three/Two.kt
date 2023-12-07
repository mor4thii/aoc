package codes.mora.aoc.twenty.three

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate

class Two(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = input.sumOf { it.toIntOrNull() ?: 0 }
    override fun two() = input.sumOf { it.toIntOrNull() ?: 0 }

    companion object {
        val maxRed = 12
        val maxBlue = 13
        val maxGreen = 14
    }
}
