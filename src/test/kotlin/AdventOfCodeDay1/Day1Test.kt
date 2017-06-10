package AdventOfCodeDay1

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Day1Test {
    var walker: Walker = Walker()

    @Before fun initialize() {
        walker.reset()
    }

    @Test fun turnRight() {
        walker.turnRight()
        Assert.assertEquals('E', walker.direction)
    }

    @Test fun turnLeft() {
        walker.turnLeft()
        Assert.assertEquals('W', walker.direction)
    }

    @Test fun forward() {
        walker.forward(5)
        Assert.assertEquals(5, walker.posY)
    }

    //Travelling based on String

    fun doTravel(input: String) {
        walker.reset()
        walker.travel(input)
    }

    @Test fun travelTest() {
        doTravel("R2, L3")
        Assert.assertEquals(2, walker.posX)
        Assert.assertEquals(3, walker.posY)
        Assert.assertEquals('N', walker.direction)
        Assert.assertEquals(5, walker.distanceFromStart)
    }

    @Test fun travelTest2(){
        doTravel("R2, R2, R2")
        Assert.assertEquals(0, walker.posX)
        Assert.assertEquals(-2, walker.posY)
        Assert.assertEquals('W', walker.direction)
        Assert.assertEquals(2, walker.distanceFromStart)
    }

    @Test fun travelTest3(){
        doTravel("R5, L5, R5, R3")
        Assert.assertEquals('S',walker.direction)
        Assert.assertEquals(12, walker.distanceFromStart)
    }
}


