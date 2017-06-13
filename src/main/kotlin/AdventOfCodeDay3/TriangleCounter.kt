package AdventOfCodeDay3

/**
 * Created by CKTox on 13-Jun-17.
 */

class TriangleCounter {
    fun countTrianglesInList(parameterList: List<String>, vertical: Boolean = false, prevTriangleCount: Int = 0, counter: Int = 0): Int {
        if (!vertical) {
            val count: Int = parameterList
                    .map { createTriangleFromParameters(it) }
                    .count { it.isValidTriangle }
            return count
        }

        if (counter == 3) {
            return prevTriangleCount
        }
        var triangleCount = prevTriangleCount
        val tempList: MutableList<String> = mutableListOf()
        for (element in parameterList) {
            tempList.add(generateTriangleParametersFromColumn(element, counter))
            if (tempList.size >= 3) {
                triangleCount = generateAndIncrementIfValidTriangle(tempList, triangleCount)
                tempList.clear()
            }
        }
        return countTrianglesInList(parameterList, vertical, triangleCount, counter + 1)
    }

    private fun generateTriangleParametersFromColumn(element: String, counter: Int): String {
        val tempList: MutableList<String> = mutableListOf()
        val elementToArray: List<String> = element.trim().split("\\s+".toRegex())
        return elementToArray[counter]
    }

    private fun createTriangleFromParameters(parameter: String): Triangle {
        val triangleParameters = parameter
                .trim()
                .split("\\s+".toRegex())
                .toMutableList()
        return Triangle(triangleParameters)
    }

    private fun generateAndIncrementIfValidTriangle(tempList: MutableList<String>, newTriangleCount: Int): Int {
        var triangleCount = newTriangleCount
        val triangle = Triangle(tempList)
        if (triangle.isValidTriangle) {
            triangleCount++
        }
        return triangleCount
    }
}