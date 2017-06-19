package AdventOfCodeDay4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day4Test {
    fun assertTrueRoom(inputString: String) {
        val input: String = inputString
        val room = Room(input)
        assertTrue { room.isRealRoom }
    }

    fun assertFalseRoom(inputString: String) {
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

    @Test fun shouldReturnRealRoom3() {
        assertTrueRoom("not-a-real-room-404[oarel]")
    }

    @Test fun shouldNotReturnRealRoom1() {
        assertFalseRoom("totally-real-room-200[decoy]")
    }

    @Test fun shouldReturn1514() {
        val room1 = Room("aaaaa-bbb-z-y-x-123[abxyz]")
        val room2 = Room("a-b-c-d-e-f-g-h-987[abcde]")
        val room3 = Room("not-a-real-room-404[oarel]")
        var sumSectorID = room1.sectorID + room2.sectorID + room3.sectorID
        assertEquals(1514, sumSectorID)
    }

    @Test fun DecrypterShouldReturnVeryEncryptedRoom(){
        val room = RoomDecrypter("qzmt-zixmtkozy-ivhz-343[abcxy]")
        assertTrue(room.decryptionList.any({it->it.contains("very encrypted name")}))
    }
}