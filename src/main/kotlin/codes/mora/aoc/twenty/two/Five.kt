package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate
import codes.mora.aoc.utils.transpose
import java.util.*

class Five(override val overwrite: List<String>? = null) : Task<String>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = reorder(input, List<Stack<String>>::popCrates)

    override fun two() = reorder(input, List<Stack<String>>::moveCrates)

    private fun reorder(input: List<String>, action: List<Stack<String>>.(Triple<Int, Int, Int>) -> Unit): String {
        val stacks = input
            .filter { it.contains('[') }
            .reversed()
            .let { parseStacks(it) }

        input
            .filter { it.contains("move") }
            .let { parseInstructions(it) }
            .forEach {
                stacks.action(it)
            }

        return stacks.map { it.last() }.reduce { a, b -> a.plus(b) }
    }

    private fun parseStacks(input: List<String>) = input
        .map { it.chunked(4) }
        .map { it.map { s -> s.filter { c -> c.isLetter() } } }
        .transpose()
        .map { it.filter { element -> element.isNotBlank() } }
        .map { Stack<String>().apply { addAll(it) } }

    private fun parseInstructions(input: List<String>) = input
        .map { it.replace("[^0-9 ]*".toRegex(), "").trim() }
        .map { it.split("  ") }
        .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
}

fun List<Stack<String>>.popCrates(
    it: Triple<Int, Int, Int>,
) {
    for (i in 1..it.first) {
        this[it.third - 1].push(this[it.second - 1].pop())
    }
}

fun List<Stack<String>>.moveCrates(
    it: Triple<Int, Int, Int>,
) {
    val foo = mutableListOf<String>()
    for (i in 1..it.first) {
        foo.add(this[it.second - 1].pop())
    }
    val reversed = foo.reversed()
    for (i in 1..it.first) {
        this[it.third - 1].push(reversed[i - 1])
    }
}
