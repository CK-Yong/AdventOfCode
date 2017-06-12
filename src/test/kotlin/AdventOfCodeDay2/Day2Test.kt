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
    var keypadNav = KeypadCracker()

    @Before fun reset(){
        keypadNav.reset()
    }

    @Test fun pressingSequenceShouldYield1985() {
        keypadNav.executeInstructions("ULL\nRRDDD\nLURDL\nUUUUD\n")
        assertEquals("1985", keypadNav.code)
    }
}

class Part2Test{
    var input = File("src/main/res/Day2_Input")
    var keypadNav = AdvancedKeypadCracker()

    @Before fun reset(){
        keypadNav.reset()
    }

    @Test fun pressingSequenceShouldYield5DB3() {
        keypadNav.executeInstructions("ULL\nRRDDD\nLURDL\nUUUUD\n")
        assertEquals("5DB3", keypadNav.code)
    }

}