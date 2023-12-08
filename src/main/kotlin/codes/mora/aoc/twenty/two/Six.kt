package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate

class Six(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = input.first().findMarker(4)

    override fun two() = input.first().findMarker(14)

    private fun String.findMarker(length: Int) = this
        .windowed(length)
        .indexOfFirst { window -> window.toSet().size == length } + length
}
