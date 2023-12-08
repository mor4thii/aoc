package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate

val lowercasePriorities = ('a'..'z').mapIndexed { index, c -> c to index + 1 }.toMap()
val uppercasePriorities = ('A'..'Z').mapIndexed { index, c -> c to index + 27 }.toMap()

class Three(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = bothCompartments(input)

    override fun two() = threeElves(input)

    private fun bothCompartments(input: List<String>) = input
        .asSequence()
        .map { splitInHalf(it) }
        .map { intersect(it) }
// This is again opinionated as we assume that there is exactly one element in the intersection. Sanitizing would be appropriate here
        .mapNotNull { it.firstOrNull() }
        .map {
            if (it.isLowerCase()) lowercasePriorities.getOrDefault(it, 0) else uppercasePriorities.getOrDefault(
                it,
                0
            )
        }
        .reduce { a, b -> a + b }

    private fun splitInHalf(line: String) =
        (line.length / 2).let { mid -> line.substring(0, mid) to line.substring(mid) }

    private fun threeElves(input: List<String>) = input
        .asSequence()
        .chunked(3)
        .map { Triple(it[0], it[1], it[2]) }
        .map { intersect(it) }
// This is again opinionated as we assume that there is exactly one element in the intersection. Sanitizing would be appropriate here
        .mapNotNull { it.firstOrNull() }
        .map {
            if (it.isLowerCase()) lowercasePriorities.getOrDefault(it, 0) else uppercasePriorities.getOrDefault(
                it,
                0
            )
        }
        .reduce { a, b -> a + b }

    private fun intersect(triple: Triple<String, String, String>) =
        intersect(triple.first to triple.second)
            .intersect(triple.third.toSet())

    private fun intersect(it: Pair<String, String>) =
        it.first.toSet()
            .intersect(it.second.toSet())
}
