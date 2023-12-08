package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate
import kotlin.math.min

class One(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = findElfCarryingMaximumCalories(input, 3).last()
    override fun two() = findElfCarryingMaximumCalories(input, 3).sum()

    private fun findElfCarryingMaximumCalories(input: List<String>, n: Int): List<Int> {
        var inventoryList = inventoryFrom(input)
        val calories = mutableListOf<List<String>>()

        while (inventoryList.isNotEmpty()) {
            val inventoryEnd = findInventoryEnd(inventoryList)
            calories.add(inventoryList.subList(0, inventoryEnd))
            inventoryList = inventoryList.subList(nextInventory(inventoryEnd, inventoryList.size), inventoryList.size)
        }

        return calories.map { sumCaloriesOfNextElf(it) }.sorted().takeLast(n)
    }

    private fun inventoryFrom(input: List<String>) = input
        .dropWhile { it.isBlank() }
        .dropLastWhile { it.isBlank() }

    private fun findInventoryEnd(inventoryList: List<String>) =
        inventoryList.indexOfFirst { it.isBlank() }.coerceAtLeast(1)

    private fun nextInventory(inventoryEnd: Int, inventorySize: Int) =
        min(inventoryEnd + 1, inventorySize)

    private fun sumCaloriesOfNextElf(calories: List<String>) = calories
        .map { it.trim() }
        .filter { it.toIntOrNull() != null }
        .sumOf { it.toInt() }
}
