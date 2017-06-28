package AdventOfCodeDay5

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ckyoung on 20-Jun-17.
 */

class Day5Test {
    @Test fun firstIndexShouldBe3231929() {
        val roomValidator: RoomValidator = RoomValidator("abc")
        val indices = roomValidator.indices
        assertEquals(3231929, indices[0])
        assertEquals(5017308, indices[1])
    }

    @Test fun passwordShouldBe18f47a30(){
        val roomValidator: RoomValidator = RoomValidator("abc")
        val password = roomValidator.password
        assertEquals("18f47a30", password)
    }
}
