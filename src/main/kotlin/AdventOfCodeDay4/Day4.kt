package AdventOfCodeDay4

import java.io.File

/**
 * Created by CKTox on 13-Jun-17.
 */
fun main(args: Array<String>) {
    val input: List<String> = File("src/main/res/Day4_Input").readLines()
    val counter: Int= input
            .map { Room(it) }
            .filter { it.isRealRoom }
            .sumBy { it.sectorID }
    println("Sum of all sector IDs:")
    println(counter)

    val northPoleRoomSectorID:Int


    for(code in input){
        val roomToDecrypt = RoomDecrypter(code)
        val decryptionList = roomToDecrypt.decryptionList
        if(decryptionList.any({str->str.trim().contains("north")})){
            println("Sector ID found, matching \'north\':")
            println(roomToDecrypt.sectorID)
            break
        }
    }
}