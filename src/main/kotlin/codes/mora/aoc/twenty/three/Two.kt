package codes.mora.aoc.twenty.three

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate

class Two(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = input
        .map { removeGamePrefix(it) }
        .map { splitGameSetsAndMapColorToCubes(it) }
        .mapIndexedNotNull { gameNumber, sets ->
            if (gameIsImpossible(sets)) {
                null
            } else {
                gameNumber + 1
            }
        }
        .sumOf { it }

    override fun two() = input
        .map { removeGamePrefix(it) }
        .map { groupCubesPerGameByColor(it) }
        .map { extractNeededAmountPerColor(it) }
        .sumOf { power(it) }

    private fun removeGamePrefix(it: String) = it.substringAfter(": ").trim()

    private fun splitGameSetsAndMapColorToCubes(game: String) =
        game.split("; ").map { set -> set.split(", ").associate { cubes(it) } }

    private fun cubes(cubes: String) = cubes.split(" ").let { Pair(it[1].trim(), it[0].trim().toInt()) }

    private fun gameIsImpossible(sets: List<Map<String, Int>>) =
        sets.any { cubes -> cubes.any { cube -> cubesOutOfLimit(cube) } }

    private fun cubesOutOfLimit(cube: Map.Entry<String, Int>) = when {
        (cube.key == "red") -> cube.value > MAX_RED
        (cube.key == "blue") -> cube.value > MAX_BLUE
        (cube.key == "green") -> cube.value > MAX_GREEN
        else -> false
    }

    private fun groupCubesPerGameByColor(game: String) =
        game.split("; ", ", ").map { cubes -> cubes(cubes) }.groupBy({ it.first }, { it.second })

    private fun extractNeededAmountPerColor(set: Map<String, List<Int>>) =
        set.entries.map { it.value.max() }

    private fun power(it: List<Int>) = it.reduce { acc, cubes -> acc * cubes }

    companion object {
        const val MAX_RED = 12
        const val MAX_GREEN = 13
        const val MAX_BLUE = 14
    }
}
