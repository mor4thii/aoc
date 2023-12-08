package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""".lines()

        assertEquals(157, Three(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(7908, Three().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""".lines()

        assertEquals(70, Three(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(2838, Three().two())
    }
}
