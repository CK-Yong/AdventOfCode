package AdventOfCodeDay2

import java.io.File

fun main(args: Array<String>) {
    var walker: Walker = Walker()
    val routeToHQ: String = File("src/main/res/Day1_Route").readText()
    walker.travel(routeToHQ)
    System.out.println("Walker is done traveling.\nDistance traveled: ${walker.distanceFromStart}")
}


class Walker{
    var posX: Int = 0
        private set
    var posY: Int = 0
        private set
    var direction: Char = 'N'
        private set
    var distanceFromStart: Int = 0
        get() = Math.abs(posX) + Math.abs(posY)
        private set
    var nodeList: MutableList<Pair<Int,Int>> = mutableListOf(Pair(0,0))

    fun travel(directions: String, tracking: Boolean = false) {
        val routeList: List<String> = directions.split(", ")
        for (subroute in routeList) {
            travelSubRoute(subroute, tracking)
        }
    }

    private fun travelSubRoute(subroute: String, tracking: Boolean = false) {
        val direction: Char = subroute[0]
        val distance: Int = Integer.parseInt(subroute.substring(1))

        when (direction) {
            'L' -> turnLeft()
            'R' -> turnRight()
        }

        if(tracking){
            forward(distance,true)
            return
        }
        forward(distance)
    }

    fun reset() {
        this.posX = 0
        this.posY = 0
        this.direction = 'N'
        this.nodeList = mutableListOf(Pair(0,0))
    }

    fun turnRight() {
        when (direction) {
            'N' -> direction = 'E'
            'E' -> direction = 'S'
            'S' -> direction = 'W'
            'W' -> direction = 'N'
        }
    }

    fun turnLeft() {
        when (direction) {
            'N' -> direction = 'W'
            'E' -> direction = 'N'
            'S' -> direction = 'E'
            'W' -> direction = 'S'
        }
    }

    fun forward(distance: Int, tracking: Boolean = false) {
        if(tracking){
            for(step in 0..distance){
                when (direction) {
                    'N' -> posY++
                    'E' -> posX++
                    'W' -> posX++
                    'S' -> posY++
                }
                nodeList.add(Pair(posX, posY))
            }
            return
        }
        when (direction) {
            'N' -> posY += distance
            'E' -> posX += distance
            'W' -> posX -= distance
            'S' -> posY -= distance
        }
    }

    //todo
    fun doTravelWithTracking(route: String, timesVisited: Int): Int {
        return 0
    }

}

