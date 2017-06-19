package AdventOfCodeDay4

/**
 * Created by ckyoung on 19-Jun-17.
 */
class RoomDecrypter(code: String) : Room(code) {
    private var shiftCipher:Int = 0
    val roomSeed = code
    var decryptionList:List<String> = generateDecryptionList()

    private fun generateDecryptionList():List<String>{
        var decryptedCodes:MutableList<String> = mutableListOf()
        for(i in 0..25){
            shiftCipher = i
            decryptedCodes.add(decryptRoomCode(roomSeed))
        }
        return decryptedCodes.toList()
    }

    private fun decryptRoomCode(input: String): String {
        val decryptedCode: StringBuilder = StringBuilder()
        for (char in input) {
            if (char == '[') {
                break
            }
            if (char.isLetter()) {
                val decryptedChar = decryptChar(char)
                decryptedCode.append(decryptedChar)
            } else {
                decryptedCode.append(" ")
            }
        }
        return decryptedCode.toString().trim()
    }

    private fun decryptChar(charToDecrypt: Char): Char {
        if (charToDecrypt + shiftCipher > 'z') {
            return 'a' + (charToDecrypt + shiftCipher -1 - 'z')
        }
        return charToDecrypt + shiftCipher
    }
}