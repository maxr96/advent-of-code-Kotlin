import kotlin.math.abs

fun main() {
    fun part1(input: LocationLists): Int {
        val left = input.left as MutableList<Int>
        left.sort()
        val right = input.right as MutableList<Int>
        right.sort()
        var totalDistance = 0
        for(i in 0..<left.size) {
            totalDistance += abs(left[i] - right[i])
        }
        return totalDistance
    }

    fun part2(input: LocationLists): Int {
        var similarityScore = 0
        for (left in input.left) {
            var multiplier = 0
            for (right in input.right) {
                if(right == left) {
                    multiplier += 1
                }
            }
            similarityScore += left * multiplier
        }
        return similarityScore
    }

    fun parseLocationLists(input: List<String>): LocationLists {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()
        for (line in input) {
            val split = line.split("\\s{3}".toRegex())
            leftList.add(split[0].toInt())
            rightList.add(split[1].toInt())
        }
        return LocationLists(leftList, rightList)
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = parseLocationLists(readInput("Day01_test"))
    part1(testInput).println()
    part2(testInput).println()

//    // Read the input from the `src/Day01.txt` file.
    val input = parseLocationLists(readInput("Day01"))
    part1(input).println()
    part2(input).println()
}

data class LocationLists(val left: List<Int>, val right: List<Int>)
