package datastructures

import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class DijkstraShortPathAlgorithmTest {

    private val graph = arrayOf(
        intArrayOf(0, 4, 0, 0, 0, 0, 0, 8, 0),
        intArrayOf(4, 0, 8, 0, 0, 0, 0, 11, 0),
        intArrayOf(0, 8, 0, 7, 0, 4, 0, 0, 2),
        intArrayOf(0, 0, 7, 0, 9, 14, 0, 0, 0),
        intArrayOf(0, 0, 0, 9, 0, 10, 0, 0, 0),
        intArrayOf(0, 0, 4, 14, 10, 0, 2, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 2, 0, 1, 6),
        intArrayOf(8, 11, 0, 0, 0, 0, 1, 0, 7),
        intArrayOf(0, 0, 2, 0, 0, 0, 6, 7, 0)
    )

    @Test
    fun findShortestPaths() {
        val dijkstraShortPathAlgorithm = DijkstraShortPathAlgorithm()

        val sourceVertex = 0

        val timeNanos = measureNanoTime {
            dijkstraShortPathAlgorithm.findShortestPaths(graph, sourceVertex)
        }

        println("Execution time: $timeNanos nanoseconds")
    }
}