package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FourTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".lines()

        assertEquals(2, Four(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(305, Four().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".lines()

        assertEquals(4, Four(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(811, Four().two())
    }
}
