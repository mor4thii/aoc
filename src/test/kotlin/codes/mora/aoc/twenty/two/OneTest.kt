package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""".lines()

        assertEquals(24000, One(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals(70374, One().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""".lines()

        assertEquals(45000, One(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals(204610, One().two())
    }
}
