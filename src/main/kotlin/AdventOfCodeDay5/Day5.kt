package AdventOfCodeDay5

/**
 * Created by ckyoung on 20-Jun-17.
 */
fun main(args: Array<String>) {
    val puzzleInput: String = "cxdnnyjw"
    val room = HashCodeGenerator(puzzleInput)
    println("Password found: ${room.roomPassword}")
}