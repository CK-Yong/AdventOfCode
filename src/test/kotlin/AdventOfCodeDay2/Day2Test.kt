package AdventOfCodeDay2

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertTrue

/**
 * Created by ckyoung on 12-Jun-17.
 */

class Day2Test {
    var keypadNav = KeypadNav()

    @Before fun resetKeypad() {
        keypadNav.reset()
    }

    @Test fun moveLeftShouldGetLeftNumber() {
        keypadNav.moveLeft()
        assertEquals(4, keypadNav.currentNumber)
    }

    @Test fun moveLeftFrom4ShouldRemainSame() {
        keypadNav.moveLeft()
        keypadNav.moveLeft()
        keypadNav.moveLeft()
        keypadNav.moveLeft()
        keypadNav.moveLeft()
        assertEquals(4, keypadNav.currentNumber)
    }

    @Test fun moveRightShouldGetRightNumber() {
        keypadNav.moveRight()
        assertEquals(6, keypadNav.currentNumber)
    }

    @Test fun moveRightFrom6ShouldRemainSame() {
        keypadNav.moveRight()
        keypadNav.moveRight()
        keypadNav.moveRight()
        keypadNav.moveRight()
        keypadNav.moveRight()
        assertEquals(6, keypadNav.currentNumber)
    }

    @Test fun moveUpShouldGetUpperNumber() {
        keypadNav.moveUp()
        assertEquals(2, keypadNav.currentNumber)
    }

    @Test fun moveUpFrom2ShouldRemainSame() {
        keypadNav.moveUp()
        keypadNav.moveUp()
        keypadNav.moveUp()
        keypadNav.moveUp()
        keypadNav.moveUp()
        assertEquals(2, keypadNav.currentNumber)
    }

    @Test fun moveDownShouldGetLowerNumber() {
        keypadNav.moveDown()
        assertEquals(8, keypadNav.currentNumber)
    }

    @Test fun moveDownFrom2ShouldRemainSame() {
        keypadNav.moveDown()
        keypadNav.moveDown()
        keypadNav.moveDown()
        keypadNav.moveDown()
        keypadNav.moveDown()
        assertEquals(8, keypadNav.currentNumber)
    }
}

class ReadFile {
    var input = File("src/main/res/Day2_Input")
    var keypadNav = KeypadNav()

    @Before fun reset(){
        keypadNav.reset()
    }

    @Test fun shouldBeAbleToReadAFile() {
        keypadNav.parseInstructions(input)
        assertTrue(keypadNav.instructions.startsWith("UUURRRRULRDLRDRRDURDDDLLDLLLULDUDDLDLULUURULRLDLRRLLLRRDRRLDDLLULUDUDDLRDRDUURDLURUURLRULLDDURULRRURDUURLULUUUURDDDDUUDLULRULLLRLLRRRURDLLRLLRRRUURULRDRUUDDDDDLLLRURRURRUURDUURDDRDLULRRLLLDRRRLURRLLURLDRRDDLDLRRLLRDRLLLLDLULDLRRDRRLDDURLULLUDLUDRRDRRLRLULURDRLRLUUUDLRLDLLLURDUDULULDDRUUURLLLDLLDDUDDRURURUDDLUULRDRRRRLDRDDURLUDURDULLDLUDLULDRLRLLRLLLLRURDURLLDRRDRLRUUUUULLLRUDURUDLLLUDLLLLRDLDRDUDRURLUDDUDDURLUUUUDDLLUDLULLLLLDUDLLRLRRDDDULULRLDRLLULDLUDLLURULRDDUURULRDLDLDLRL"))
    }

    @Test fun pressingSequenceShouldYield1985() {
        keypadNav.parseInstructions(input)
        keypadNav.executeInstructions("ULL\nRRDDD\nLURDL\nUUUUD\n")
        assertEquals("1985", keypadNav.code)
    }
}
