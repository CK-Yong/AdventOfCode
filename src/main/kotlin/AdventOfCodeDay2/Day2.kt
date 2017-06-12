package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
fun main(args: Array<String>) {
    val input = File("src/main/res/Day2_Input")
    val keypadCracker = KeypadCracker()
    val advKPCracker = AdvancedKeypadCracker()
    val instructions: String = parseInstructions(input)

    keypadCracker.executeInstructions(instructions)
    advKPCracker.executeInstructions(instructions)

    System.out.println("Parsed a code: ${keypadCracker.code}")
    System.out.println("Parsed adv code: ${advKPCracker.code}")
}

fun parseInstructions(instructions: File): String {
    return instructions.readText()
}