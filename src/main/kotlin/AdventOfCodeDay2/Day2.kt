package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
fun main(args: Array<String>) {
    val input = File("src/main/res/Day2_Input")
    val keypadNav = KeypadCracker()
    keypadNav.parseInstructions(input)
    val instructions: String = keypadNav.instructions
    keypadNav.executeInstructions(instructions)

    System.out.println("Parsed a code: ${keypadNav.code}")

    val advKPCracker = AdvancedKeypadCracker()
    advKPCracker.executeInstructions(instructions)
    System.out.println("Parsed adv code: ${advKPCracker.code}")
}