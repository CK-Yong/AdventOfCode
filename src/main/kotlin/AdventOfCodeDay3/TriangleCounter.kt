package AdventOfCodeDay3

/**
 * Created by CKTox on 13-Jun-17.
 */

class TriangleCounter() {
    fun countTrianglesInList(parameterList: List<String>): Int {
        val count: Int = parameterList
                .map { createTriangleFromParameters(it) }
                .count { it.isValidTriangle }
        return count
    }

    private fun createTriangleFromParameters(parameter: String): Triangle {
        val triangleParameters = parameter
                .trim()
                .split("\\s+".toRegex())
                .toMutableList()
        return Triangle(triangleParameters)
    }

    fun countVerticalTrianglesInList(parameterList: List<String>, prevTriangleCount: Int = 0, counter: Int = 0): Int {
        var triangleCount = prevTriangleCount
        val tempList: MutableList<String> = mutableListOf()
        var elementToArray: List<String>

        if (counter == 3) {
            return prevTriangleCount
        }

        for (element in parameterList) {
            elementToArray = element.trim().split("\\s+".toRegex())
            tempList.add(elementToArray[counter])

            if (tempList.size >= 3) {
                triangleCount = generateAndIncrementIfValidTriangle(tempList, triangleCount)
            }
        }
        return countVerticalTrianglesInList(parameterList, triangleCount, counter + 1)
    }

    private fun generateAndIncrementIfValidTriangle(tempList: MutableList<String>, newTriangleCount: Int): Int {
        var triangleCount = newTriangleCount
        val triangle = Triangle(tempList)
        if (triangle.isValidTriangle) {
            triangleCount++
        }
        tempList.clear()
        return triangleCount
    }
}