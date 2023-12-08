package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SixTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """mjqjpqmgbljsphdztnvjfqwrcgsmlb""".lines()

        assertEquals(7, Six(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(1850, Six().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """mjqjpqmgbljsphdztnvjfqwrcgsmlb""".lines()

        assertEquals(19, Six(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(2823, Six().two())
    }
}
