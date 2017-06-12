package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
class AdvancedKeypadCracker : KeypadCracker() {
    var currentChar: Char = '0'
        private set

    override fun executeInstructions(instructions: String) {
        for (char in instructions) {
            if (char == '\n') {
                code += currentChar
                continue
            }
            pressKey(char)
        }
    }

    private fun pressKey(char: Char) {
        when (char) {
            'U' -> moveUp()
            'L' -> moveLeft()
            'R' -> moveRight()
            'D' -> moveDown()
        }
        mapToChar()
    }

    private fun moveLeft() {
        when (currentNumber) {
            1, 2, 5, 10, 15 -> return
            else -> currentNumber -= 1
        }
    }

    private fun moveRight() {
        when (currentNumber) {
            1, 4, 9, 12, 15 -> return
            else -> currentNumber += 1
        }
    }

    private fun moveUp() {
        when (currentNumber) {
            5, 2, 1, 4, 9 -> return
            3 -> currentNumber -= 2
            else -> currentNumber -= 4
        }

    }

    private fun moveDown() {
        when (currentNumber) {
            5, 10, 15, 12, 9 -> return
            1 -> currentNumber += 2
            else -> currentNumber += 4
        }

    }

    private fun mapToChar() {
        when (currentNumber) {
            10 -> currentChar = 'A'
            11 -> currentChar = 'B'
            12 -> currentChar = 'C'
            15 -> currentChar = 'D'
            else -> currentChar = currentNumber.toString()[0]
        }
    }
}
