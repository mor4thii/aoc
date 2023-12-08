package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EightTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """30373
25512
65332
33549
35390""".lines()

        assertEquals(21, Eight(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(1681, Eight().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """30373
25512
65332
33549
35390""".lines()

        assertEquals(8, Eight(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(201684, Eight().two())
    }
}
