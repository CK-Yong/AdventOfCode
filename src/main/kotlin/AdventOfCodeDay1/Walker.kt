package AdventOfCodeDay1

class Walker {
    var posX: Int = 0
        private set
    var posY: Int = 0
        private set
    var direction: Char = 'N'
        private set
    var distanceFromStart: Int = 0
        get() = Math.abs(posX) + Math.abs(posY)
        private set
    var nodeList: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0, 0))

    fun travel(directions: String, tracking: Boolean = false) {
        reset()
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

        if (tracking) {
            forward(distance, true)
            return
        }

        forward(distance)
    }

    private fun turnRight() {
        when (direction) {
            'N' -> direction = 'E'
            'E' -> direction = 'S'
            'S' -> direction = 'W'
            'W' -> direction = 'N'
        }
    }

    private fun turnLeft() {
        when (direction) {
            'N' -> direction = 'W'
            'E' -> direction = 'N'
            'S' -> direction = 'E'
            'W' -> direction = 'S'
        }
    }

    private fun forward(distance: Int, tracking: Boolean = false, counter: Int = 0) {
        if (distance == counter) {
            return
        }

        when (direction) {
            'N' -> posY++
            'E' -> posX++
            'W' -> posX--
            'S' -> posY--
        }

        if (tracking) {
            nodeList.add(Pair(posX, posY))
        }

        return forward(distance, tracking, counter + 1)
    }

    fun reset() {
        this.posX = 0
        this.posY = 0
        this.direction = 'N'
        this.nodeList = mutableListOf(Pair(0, 0))
    }

}

