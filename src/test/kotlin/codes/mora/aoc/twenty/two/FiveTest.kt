package codes.mora.aoc.twenty.two

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FiveTest {
    @Test
    fun oneWithExampleData() {
        val overwrite = """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2""".lines()

        assertEquals("CMZ", Five(overwrite = overwrite).one())
    }

    @Test
    fun one() {
        assertEquals("HNSNMTLHQ", Five().one())
    }

    @Test
    fun twoWithExampleData() {
        val overwrite = """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2""".lines()

        assertEquals("MCD", Five(overwrite = overwrite).two())
    }

    @Test
    fun two() {
        assertEquals("RNLFDJMCT", Five().two())
    }
}
