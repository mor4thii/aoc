package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate
import kotlin.math.max

class Eight(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    private val parsedInput = input.map { it.map(Char::digitToInt) }

    override fun one() = treesSeenFromTheOutside(parsedInput)

    override fun two() = viewingDistance(parsedInput)

    private fun treesSeenFromTheOutside(
        input: List<List<Int>>,
    ): Int {
        val indices = input.indices
        val visible = mutableSetOf<Pair<Int, Int>>()

        for (i in indices) {
            for (direction in listOf(indices, indices.reversed())) {
                var maximum = -1
                for (x in direction) {
                    val current = input[i][x]
                    if (current > maximum) {
                        visible.add(i to x)
                    }
                    maximum = max(maximum, current)
                }
                maximum = -1
                for (y in direction) {
                    val current = input[y][i]
                    if (current > maximum) {
                        visible.add(y to i)
                    }
                    maximum = max(maximum, current)
                }
            }
        }

        return visible.size
    }

    private fun viewingDistance(
        input: List<List<Int>>,
    ): Int {
        val indices = input.indices
        val vonNeumannNeighbors = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)

        var best = 0
        for (y in indices) {
            for (x in indices) {
                var scenicValue = 1
                for ((dy, dx) in vonNeumannNeighbors) {
                    var distance = 0
                    var ys = y + dy
                    var xs = x + dx
                    while (indices.twoDimensionallyContains(ys, xs)) {
                        distance += 1
                        if (input[ys][xs] >= input[y][x]) break
                        ys += dy
                        xs += dx
                    }
                    scenicValue *= distance
                }
                best = max(best, scenicValue)
            }
        }

        return best
    }

    private fun IntRange.twoDimensionallyContains(ys: Int, xs: Int) =
        this.contains(ys) && this.contains(xs)
}
