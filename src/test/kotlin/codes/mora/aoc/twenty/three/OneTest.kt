package codes.mora.aoc.twenty.three

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet""".lines()

        assertEquals(142, One(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(54968, One().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen""".lines()

        assertEquals(281, One(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(54094, One().two())
    }
}
