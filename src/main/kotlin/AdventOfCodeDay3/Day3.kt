package AdventOfCodeDay3

import java.io.File

fun main(args: Array<String>) {
    val fileToRead = File("src/main/res/Day3_Input")
    val parameterList: List<String> = fileToRead.readLines()
    val triangleCounter = TriangleCounter()
    val count: Int = triangleCounter.countTrianglesInList(parameterList)

    println("Counted all valid triangles: $count")

    val countVertical: Int = triangleCounter.countTrianglesInList(parameterList,true)
    println("Counted all vertical triangles: $countVertical")
}