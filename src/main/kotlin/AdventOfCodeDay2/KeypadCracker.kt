package AdventOfCodeDay2

import java.io.File

/**
 * Created by ckyoung on 12-Jun-17.
 */
open class KeypadCracker {
    protected var currentNumber: Int = 5
        protected set
    var code: String = ""

    open fun executeInstructions(instructions: String){
        for(char in instructions){
            if(char=='\n'){
                code += currentNumber
                continue
            }
            pressKey(char)
        }
    }

    private fun pressKey(char: Char){
        when(char){
            'U'-> moveUp()
            'L'-> moveLeft()
            'R'-> moveRight()
            'D'-> moveDown()
        }
    }

    private fun moveLeft() {
        when (currentNumber) {
            1, 4, 7 -> return
        }
        currentNumber -= 1
    }

    private fun moveRight() {
        when (currentNumber) {
            3, 6, 9 -> return
        }
        currentNumber += 1
    }

    private fun moveUp() {
        when (currentNumber) {
            1, 2, 3 -> return
        }
        currentNumber -= 3
    }

    private fun moveDown() {
        when (currentNumber) {
            7, 8, 9 -> return
        }
        currentNumber += 3
    }

    fun reset() {
        currentNumber = 5

    }
}
