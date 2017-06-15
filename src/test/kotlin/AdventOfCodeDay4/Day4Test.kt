package AdventOfCodeDay4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by CKTox on 13-Jun-17.
 */
class Day4Test {
    fun assertTrueRoom(inputString: String){
        val input: String = inputString
        val room = Room(input)
        assertTrue { room.isRealRoom }
    }

    fun assertFalseRoom(inputString: String){
        val input: String = inputString
        val room = Room(input)
        assertFalse { room.isRealRoom }
    }

    @Test fun shouldReturnRealRoom1() {
        assertTrueRoom("aaaaa-bbb-z-y-x-123[abxyz]")
    }

    @Test fun shouldReturnRealRoom2() {
        assertTrueRoom("a-b-c-d-e-f-g-h-987[abcde]")
    }

    @Test fun shouldReturnRealRoom3(){
        assertTrueRoom("not-a-real-room-404[oarel]")
    }

    @Test fun shouldNotReturnRealRoom1(){
        assertFalseRoom("totally-real-room-200[decoy]")
    }
}