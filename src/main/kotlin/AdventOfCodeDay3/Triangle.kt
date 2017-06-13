package AdventOfCodeDay3

/**
 * Created by ckyoung on 13-Jun-17.
 */

class Triangle(parameters: List<String>) {
    val sideA: Int = parameters[0].toInt()
    val sideB: Int = parameters[1].toInt()
    val sideC: Int = parameters[2].toInt()
    val isValidTriangle: Boolean = checkTriangle()

    private fun checkTriangle(): Boolean {
        return sideC < sideA + sideB &&
                sideB < sideC + sideA &&
                sideA < sideB + sideC
    }
}