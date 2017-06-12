package AdventOfCodeDay1

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Day1Test {
    var walker: Walker = Walker()

    @Before fun initialize() {
        walker.reset()
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

    @Test fun travelTest2() {
        doTravel("R2, R2, R2")
        Assert.assertEquals(0, walker.posX)
        Assert.assertEquals(-2, walker.posY)
        Assert.assertEquals('W', walker.direction)
        Assert.assertEquals(2, walker.distanceFromStart)
    }

    @Test fun travelTest3() {
        doTravel("R5, L5, R5, R3")
        Assert.assertEquals('S', walker.direction)
        Assert.assertEquals(12, walker.distanceFromStart)
    }
}

class Day1TestPart2 {
    var walker: Walker = Walker()

    @Before fun initialize() {
        walker.reset()
    }

    @Test fun trackTravel() {
        walker.travel("R8, R4, R4, R8", true)
        Assert.assertEquals(25,walker.nodeList.size)
        Assert.assertEquals(Pair(0,0), walker.nodeList[0])
        Assert.assertEquals(Pair(1,0), walker.nodeList[1])
        Assert.assertEquals(Pair(2,0), walker.nodeList[2])
        Assert.assertEquals(Pair(3,0), walker.nodeList[3])
        Assert.assertEquals(Pair(4,0), walker.nodeList[4])
        Assert.assertEquals(Pair(5,0), walker.nodeList[5])
        Assert.assertEquals(Pair(6,0), walker.nodeList[6])
        Assert.assertEquals(Pair(7,0), walker.nodeList[7])
        Assert.assertEquals(Pair(8,0), walker.nodeList[8])
        Assert.assertEquals(Pair(8,-1), walker.nodeList[9])
        Assert.assertEquals(Pair(8,-2), walker.nodeList[10])
        Assert.assertEquals(Pair(8,-3), walker.nodeList[11])
        Assert.assertEquals(Pair(8,-4), walker.nodeList[12])
        Assert.assertEquals(Pair(7,-4), walker.nodeList[13])
        Assert.assertEquals(Pair(6,-4), walker.nodeList[14])
        Assert.assertEquals(Pair(5,-4), walker.nodeList[15])
        Assert.assertEquals(Pair(4,-4), walker.nodeList[16])
        Assert.assertEquals(Pair(4,-3), walker.nodeList[17])
        Assert.assertEquals(Pair(4,-2), walker.nodeList[18])
        Assert.assertEquals(Pair(4,-1), walker.nodeList[19])
        Assert.assertEquals(Pair(4,-0), walker.nodeList[20])
        Assert.assertEquals(Pair(4,1), walker.nodeList[21])
        Assert.assertEquals(Pair(4,2), walker.nodeList[22])
        Assert.assertEquals(Pair(4,3), walker.nodeList[23])
        Assert.assertEquals(Pair(4,4), walker.nodeList[24])
    }

}