package AdventOfCodeDay3

import java.io.File

/**
 * Created by ckyoung on 13-Jun-17.
 */

fun main(args: Array<String>) {
    val fileToRead = File("src/main/res/Day3_Input")
    var count: Int = 0

    var parameterList: List<String> = fileToRead.readLines()
    for (parameter in parameterList) {
        val triangleParameters = trimWhiteSpaces(parameter)
        val triangle = Triangle(triangleParameters)
        if (triangle.isValidTriangle) {
            count++
        }
    }
    println("Counted all valid triangles: $count")
}

private fun trimWhiteSpaces(parameter: String): List<String> {
    val triangleParameters = parameter.trim().split("    ", "   ", "  ", " ").toMutableList()
    for (i in triangleParameters.indices) {
        triangleParameters[i] = triangleParameters[i]
    }
    return triangleParameters
}