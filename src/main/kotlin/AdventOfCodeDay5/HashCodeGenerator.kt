package AdventOfCodeDay5

import java.security.MessageDigest

class HashCodeGenerator(inputDoorID: String) {
    private var validHashCodes:MutableList<String> = arrayListOf()
    val doorID = inputDoorID
    val indexList = getIndices()
    val roomPassword = getPassword()

    private fun getIndices(): List<Int> {
        val indices: MutableList<Int> = arrayListOf()
        var counter = 0
        for (i in 0..7) {
            counter = counter.findNextIndex()
            indices.add(counter)
        }
        return indices
    }

    private fun getPassword(): String{
        val password = StringBuilder()
        for(hash in validHashCodes){
            password.append(hash[5].toLowerCase())
        }
        return password.toString()
    }

    private fun Int.findNextIndex(): Int {
        var currentIndex: Int = this+1

        while (!isValidHash(currentIndex)) {
            currentIndex++
        }
        return currentIndex
    }

    private fun isValidHash(index: Int): Boolean {
        val stringToConvert = this.doorID + index
        val hashCode: MessageDigest = MessageDigest.getInstance("MD5")
        hashCode.update(stringToConvert.toByteArray())
        val processedHash: ByteArray = hashCode.digest()
        val hashToString: String = processedHash.toHex()

        if (hashToString.startsWith("00000")) {
            validHashCodes.add(hashToString)
            return true
        }
        return false
    }

}

