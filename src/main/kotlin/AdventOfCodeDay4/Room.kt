package AdventOfCodeDay4

/**
 * Created by ckyoung on 15-Jun-17.
 */
open class Room(code: String) {
    val isRealRoom: Boolean = checkIfValid(code)
    val sectorID: Int = extractSectorID(code)

    private fun  extractSectorID(input: String): Int {
        val sectorIdBuilder: StringBuilder = StringBuilder()
        for(char in input){
            if(char.isDigit()){
                sectorIdBuilder.append(char)
            }
        }
        return Integer.parseInt(sectorIdBuilder.toString())
    }

    private fun checkIfValid(input: String): Boolean {
        val (code: String, checksum: String) = GenerateCodeAndCheckSumPair(input)
        if (code == checksum) {
            return true
        }
        return false
    }

    private fun GenerateCodeAndCheckSumPair(input: String): Pair<String, String> {
        val codeAndCheckSumArray = input.split("[", "]").toMutableList()
        codeAndCheckSumArray.removeIf { it.isEmpty() }

        val letterPool = generateLetterPool(codeAndCheckSumArray)
        val countedLettersList: List<Pair<Char, Int>> = countLettersInPoolReturnPairList(letterPool)
        val sortedList: List<Pair<Char, Int>> = countedLettersList
                .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }
                        .thenBy { it.first })
        val code: String = generateCodeFromList(sortedList)
        val checksum: String = codeAndCheckSumArray[1]
        return Pair(code, checksum)
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

    private fun countLettersInPoolReturnPairList(letterPool: MutableList<Char>): MutableList<Pair<Char, Int>> {
        val usedLetters: MutableList<Pair<Char, Int>> = arrayListOf()
        for (char in letterPool) {
            val counter = letterPool.count({ it == char })
            val pairToCheck = Pair(char, counter)
            if (usedLetters.contains(pairToCheck)) {
                continue
            }
            if (pairToCheck.first.isLetter()) {
                usedLetters.add(pairToCheck)
            }
        }
        return usedLetters
    }

    private fun generateCodeFromList(sortedList: List<Pair<Char, Int>>): String {
        val code: StringBuilder = StringBuilder()
        for (i in 0..4) {
            code.append(sortedList[i].first)
        }
        return code.toString()
    }
}