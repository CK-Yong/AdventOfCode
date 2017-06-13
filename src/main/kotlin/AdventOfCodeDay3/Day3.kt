package AdventOfCodeDay3

import java.io.File

/**
 * Created by ckyoung on 13-Jun-17.
 */

fun main(args: Array<String>) {
    val fileToRead = File("src/main/res/Day3_Input")
    var parameterList: List<String> = fileToRead.readLines()
    var count: Int = countValidTrianglesInList(parameterList)

    println("Counted all valid triangles: $count")
}

private fun countValidTrianglesInList(parameterList: List<String>): Int {
    var count: Int = 0
    for (parameter in parameterList) {
        val triangleParameters = convertToParameterList(parameter)
        val triangle = Triangle(triangleParameters)
        if (triangle.isValidTriangle) {
            count++
        }
    }
    return count
}

private fun convertToParameterList(parameter: String): List<String> {
    val triangleParameters = parameter.trim().split("\\s+".toRegex()).toMutableList()
    for (i in triangleParameters.indices) {
        triangleParameters[i] = triangleParameters[i]
    }
    return triangleParameters
}