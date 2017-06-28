package AdventOfCodeDay5

import java.security.MessageDigest

class RoomValidator(inputDoorID: String) {
    private var validHashCodes: MutableList<String> = arrayListOf()
    val doorID = inputDoorID
    val indexList = getIndices()
    val roomPassword = getPassword()

    private fun getIndices(): List<Int> {
        val indices: MutableList<Int> = arrayListOf()
        var counter: Int = 0
        for (i in 0..7) {
            counter = counter.findNextIndex()
            indices.add(counter)
        }
        return indices
    }

    private fun getPassword(): String {
        val password = StringBuilder()
        for (hash in validHashCodes) {
            password.append(hash[5].toLowerCase())
        }
        return password.toString()
    }

    private fun Int.findNextIndex(): Int {
        var currentIndex: Int = this + 1
        while (!validHashAddedToList(currentIndex)) {
            currentIndex++
        }
        return currentIndex
    }

    private fun validHashAddedToList(index: Int): Boolean {
        val stringToConvert = this.doorID + index
        val hashToString: String = generateHashInHex(stringToConvert)
        if (hashToString.startsWith("00000")) {
            validHashCodes.add(hashToString)
            return true
        }
        return false
    }

    private fun generateHashInHex(stringToConvert: String): String {
        val hashCode: MessageDigest = MessageDigest.getInstance("MD5")
        hashCode.update(stringToConvert.toByteArray())
        val processedHash: ByteArray = hashCode.digest()
        val hashToString: String = processedHash.toHex()
        return hashToString
    }

}

