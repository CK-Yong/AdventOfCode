package AdventOfCodeDay3

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ckyoung on 13-Jun-17.
 */

class Day3TestP1 {
    @Test fun checkIf_5_10_25_IsInvalid() {
        val parameters: List<String> = listOf("5", "10", "25")
        val triangle = Triangle(parameters)
        assertEquals(false, triangle.isValidTriangle)
    }
}