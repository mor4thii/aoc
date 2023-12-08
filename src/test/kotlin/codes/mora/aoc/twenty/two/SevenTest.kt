package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SevenTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k""".lines()

        assertEquals(95437, Seven(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(1908462, Seven().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k""".lines()

        assertEquals(24933642, Seven(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(3979145, Seven().two())
    }
}
