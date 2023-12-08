package codes.mora.aoc.twenty.two

import codes.mora.aoc.Task
import codes.mora.aoc.WithOverwrite
import codes.mora.aoc.utils.InputDelegate
import codes.mora.aoc.utils.toPair

data class Tree(val nodeName: String, val parent: Tree?) {
    var size: Int = 0
    val children: MutableList<Tree> = mutableListOf()

    fun sizes(sizes: MutableList<Int>): Int =
        sizes.add(this.size + this.children.sumOf { it.sizes(sizes) }).let { sizes.last() }
}

class Seven(override val overwrite: List<String>? = null) : Task<Int>, WithOverwrite {
    override val input: List<String> by InputDelegate(overwrite)

    override fun one() = sumOfDirectoriesSub100k(input.parseTree())

    override fun two() = freeDiskSpace(input.parseTree())

    private fun List<String>.parseTree(): Tree {
        val root = Tree("/", null)
        var current: Tree = root
        this
            .asSequence()
            .map { it.replace("$ ", "") }
            .filterNot { it == "ls" }
            .map { it.split(" ").toPair() }
            .forEach { argLine ->
                when (argLine.first) {
                    "cd" -> current = when (argLine.second) {
                        "/" -> root
                        ".." -> current.parent!!
                        else -> current.children.find { it.nodeName == argLine.second }!!
                    }

                    "dir" -> current.children.add(Tree(argLine.second, current))
                    else -> current.size += argLine.first.toInt()
                }
            }

        return root
    }

    private fun sumOfDirectoriesSub100k(root: Tree): Int {
        val sizes: MutableList<Int> = sizes(root)

        return sizes.filter { it <= 100000 }.sum()
    }

    private fun freeDiskSpace(root: Tree): Int {
        val sizes: MutableList<Int> = sizes(root)

        return sizes.filter { it >= 30000000 - 70000000 + sizes.max() }.min()
    }

    private fun sizes(root: Tree): MutableList<Int> {
        val sizes: MutableList<Int> = mutableListOf()
        root.sizes(sizes)
        return sizes
    }
}
