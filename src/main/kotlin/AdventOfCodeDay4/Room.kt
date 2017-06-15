package AdventOfCodeDay4

import java.util.function.Predicate

/**
 * Created by ckyoung on 15-Jun-17.
 */
class Room(code: String) {
    val isRealRoom: Boolean = checkIfValid(code);

    private fun checkIfValid(input: String): Boolean{
        val codePair = input.split("[","]").toMutableList()
        codePair.removeIf{it.isEmpty()}
        val letterPool = generateLetterPool(codePair)

        for(char in letterPool){
            letterPool.count(//todo)
        }

        return false
    }

    private fun generateLetterPool(codePair: MutableList<String>): MutableList<Char> {
        val letterPool: MutableList<Char> = arrayListOf()
        for (char in codePair[0]) {
            if (char == '-') {
                continue
            }
            letterPool.add(char)
        }
        return letterPool
    }
}