package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """A Y
B X
C Z""".lines()

        assertEquals(15, Two(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(11841, Two().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """A Y
B X
C Z""".lines()

        assertEquals(12, Two(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(13022, Two().two())
    }
}
