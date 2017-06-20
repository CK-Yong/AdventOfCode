package AdventOfCodeDay5

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ckyoung on 20-Jun-17.
 */

class Day5Test {
    @Test fun firstIndexShouldBe3231929() {
        val hashCodeGenerator: HashCodeGenerator = HashCodeGenerator("abc")
        assertEquals(3231929, hashCodeGenerator.getIndices()[0])
    }
}
