package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
class KeypadNav {
    var currentNumber: Int = 5
        private set
    var instructions: String = ""
    var code: String = ""

    fun parseInstructions(instructions: File){
        this.instructions = instructions.readText()
    }

    fun executeInstructions(instructions: String){
        for(char in instructions){
            if(char=='\n'){
                code += currentNumber
                continue
            }
            pressKey(char)
        }
    }

    fun pressKey(char: Char){
        when(char){
            'U'-> moveUp()
            'L'-> moveLeft()
            'R'-> moveRight()
            'D'-> moveDown()
        }
    }

    fun moveLeft() {
        when (currentNumber) {
            1, 4, 7 -> return
        }
        currentNumber -= 1
    }

    fun moveRight() {
        when (currentNumber) {
            3, 6, 9 -> return
        }
        currentNumber += 1
    }

    fun moveUp() {
        when (currentNumber) {
            1, 2, 3 -> return
        }
        currentNumber -= 3
    }

    fun moveDown() {
        when (currentNumber) {
            7, 8, 9 -> return
        }
        currentNumber += 3
    }

    fun reset() {
        currentNumber = 5

    }
}
