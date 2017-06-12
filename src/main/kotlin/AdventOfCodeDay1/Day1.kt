package AdventOfCodeDay1

import java.io.File

fun main(args: Array<String>) {
    var walker: Walker = Walker()
    val routeToHQ: String = File("src/main/res/Day1_Route").readText()
    walker.travel(routeToHQ)
    System.out.println("Walker is done traveling.\nDistance traveled: ${walker.distanceFromStart}")

    walker.travel(routeToHQ, true)

    var revisitedDistance: Int = calcDistance(countRevistedLoc(walker))
    System.out.println("Distance to revisited location: " + revisitedDistance)
}

private fun countRevistedLoc(walker: Walker): Pair<Int, Int> {
    var firstMatch: Pair<Int, Int> = Pair(0,0)
    for (element in walker.nodeList) {
        if (walker.nodeList.count({ it -> it == element }) == 2) {
            firstMatch = element
            System.out.println("\nFirst location that was visited twice: " + firstMatch)
            break
        }
    }
    return firstMatch
}

private fun calcDistance(pair: Pair<Int, Int>): Int {
    return Math.abs(pair.first) + Math.abs(pair.second)
}