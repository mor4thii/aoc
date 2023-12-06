package codes.mora.aoc.twenty.three

import codes.mora.aoc.Task
import codes.mora.aoc.utils.InputDelegate

class One : Task<Int> {
    override val input: List<String> by InputDelegate()

    override fun one() = input.sumOfCalibrationValue()
    override fun two() = input
        .map { line -> line.replaceAll(mappings) }
        .sumOfCalibrationValue()

    companion object {
        private val mappings = mapOf(
            "one" to "o1e",
            "two" to "t2o",
            "three" to "t3e",
            "four" to "f4r",
            "five" to "f5e",
            "six" to "s6x",
            "seven" to "s7n",
            "eight" to "e8t",
            "nine" to "n9e"
        )

        private fun List<String>.sumOfCalibrationValue(): Int = this
            .asSequence()
            .map { it.filter { c -> c.isDigit() } }
            .filter { it.isNotBlank() }
            .mapNotNull { "${it.first()}${it.last()}".toIntOrNull() }
            .sumOf { it }

        private fun String.replaceAll(mappings: Map<String, String>): String {
            var result = this
            mappings.forEach { result = result.replace(it.key.toRegex(), it.value) }
            return result
        }
    }
}
