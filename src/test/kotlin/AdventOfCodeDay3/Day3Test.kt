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

    @Test fun shouldReturn0Triangles(){
        val parameters: List<String> = listOf("5 10 25")
        val triangleCounter = TriangleCounter()
        assertEquals(0, triangleCounter.countTrianglesInList(parameters))
    }

    @Test fun shouldReturn1Triangle(){
        val parameters: List<String> = listOf("10 10 10")
        val triangleCounter = TriangleCounter()
        assertEquals(1, triangleCounter.countTrianglesInList(parameters))
    }

    @Test fun shouldReturn6Triangles() {
        val triangleCounter = TriangleCounter()
        val rawData: List<String> = """101 301 501
102 302 502
103 303 503
201 401 601
202 402 602
203 403 603""".trim().split("[\\n]".toRegex())

        assertEquals(6, triangleCounter.countVerticalTrianglesInList(rawData))
    }
}