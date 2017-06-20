package AdventOfCodeDay5

/**
 * Created by ckyoung on 20-Jun-17.
 */
class HashCodeGenerator(inputDoorID: String) {
    val doorID = inputDoorID

    fun getIndices(): List<Int> {
        val indices: MutableList<Int> = arrayListOf()

        indices.add(findNextIndex())

        return indices
    }

    private fun findNextIndex(index: Int = 0): Int {
        var currentIndex = index
        while (!isValidHash(currentIndex)) {
            currentIndex++
        }
        return currentIndex
    }

    private fun isValidHash(index: Int): Boolean {
        val hashCode: String = generateMD5(doorID + index)
        if (hashCode.startsWith("00000")) {
            return true
        }
        return false
    }

    private fun generateMD5(input: String): String {
        val s: MutableList<Int> = arrayListOf()
        val k: MutableList<Int> = arrayListOf()
        var inputInBinary: MutableList<Int> = input.toCharArray().map { it -> it.toInt() }.toMutableList()

        s.plusAssign(listOf(7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22))
        s.plusAssign(listOf(5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20))
        s.plusAssign(listOf(4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23))
        s.plusAssign(listOf(6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21))

        k.plusAssign(listOf(0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee).filterIsInstance<Int>())
        k.plusAssign(listOf(0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501).filterIsInstance<Int>())
        k.plusAssign(listOf(0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be).filterIsInstance<Int>())
        k.plusAssign(listOf(0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821).filterIsInstance<Int>())
        k.plusAssign(listOf(0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa).filterIsInstance<Int>())
        k.plusAssign(listOf(0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8).filterIsInstance<Int>())
        k.plusAssign(listOf(0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed).filterIsInstance<Int>())
        k.plusAssign(listOf(0xa9e3e905, 0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a).filterIsInstance<Int>())
        k.plusAssign(listOf(0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c).filterIsInstance<Int>())
        k.plusAssign(listOf(0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70).filterIsInstance<Int>())
        k.plusAssign(listOf(0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05).filterIsInstance<Int>())
        k.plusAssign(listOf(0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665).filterIsInstance<Int>())
        k.plusAssign(listOf(0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039).filterIsInstance<Int>())
        k.plusAssign(listOf(0x655b59c3, 0x8f0ccc92, 0xffeff47d, 0x85845dd1).filterIsInstance<Int>())
        k.plusAssign(listOf(0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1).filterIsInstance<Int>())
        k.plusAssign(listOf(0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391).filterIsInstance<Int>())

        applyPadding(inputInBinary)

        var a0: Long = 0x67452301.toLong()
        var b0: Long = 0xefcdab89
        var c0: Long = 0x98badcfe
        var d0: Long = 0x10325476.toLong()

        //Todo: Word processing for MD5

        return k.toString()
    }

    private fun applyPadding(inputInBinary: MutableList<Int>): MutableList<Int> {
        var messageLengthInBits = inputInBinary.size * 8
        inputInBinary.add(128)

        while ((calcBinaryLength(inputInBinary) + 64) % 512 != 0) {
            inputInBinary.plusAssign(List((448 - calcBinaryLength(inputInBinary)) / 8, { 0 }))
        }

        while (messageLengthInBits > 128) {
            inputInBinary.add(128)
            messageLengthInBits -= 128
        }

        inputInBinary.add(messageLengthInBits)

        while (calcBinaryLength(inputInBinary) % 512 != 0) {
            inputInBinary.add(0)
        }
        return inputInBinary
    }

    private fun calcBinaryLength(input: MutableList<Int>): Int {
        return input.size * 8
    }
}