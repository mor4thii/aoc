package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate
import codes.mora.aoc.utils.toPair

class Four(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = getRanges(input).count { it.first contains it.second || it.second contains it.first }

    override fun two() = getRanges(input).count { it.first intersects it.second }

    private fun getRanges(input: List<String>) = input
        .asSequence()
        .map { it.split(",").toPair() }
        .map { it.first.split("-").toPair() to it.second.split("-").toPair() }
        .map {
            it.first.first.toInt()..it.first.second.toInt() to it.second.first.toInt()..it.second.second.toInt()
        }

    private infix fun IntRange.contains(other: IntRange) = min() <= other.min() && other.max() <= max()
    private infix fun IntRange.intersects(other: IntRange) = min() <= other.max() && other.min() <= max()
}
