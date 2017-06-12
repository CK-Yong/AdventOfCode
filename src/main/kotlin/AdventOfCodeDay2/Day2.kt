package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
fun main(args: Array<String>) {
    var input = File("src/main/res/Day2_Input")
    var keypadNav = KeypadNav()
    keypadNav.parseInstructions(input)
    var instructions: String = keypadNav.instructions
    keypadNav.executeInstructions(instructions)

    System.out.println("Parsed a code: ${keypadNav.code}")
}