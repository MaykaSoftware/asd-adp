package datastructures

internal class DijkstraShortPathAlgorithm {

    private var numberOfVertices = 0

    fun findShortestPaths(graph: Array<IntArray>, source: Int): IntArray {
        numberOfVertices = graph.size

        val distances = IntArray(numberOfVertices)
        val shortestPathTreeSet = BooleanArray(numberOfVertices)

        for (vertex in 0..<numberOfVertices) {
            distances[vertex] = Int.MAX_VALUE
            shortestPathTreeSet[vertex] = false
        }

        distances[source] = 0

        for (count in 0..<numberOfVertices - 1) {
            val currentVertex = getMinimumDistanceVertex(distances, shortestPathTreeSet)

            shortestPathTreeSet[currentVertex] = true

            for (adjacentVertex in 0..<numberOfVertices) {
                if (!shortestPathTreeSet[adjacentVertex] && graph[currentVertex][adjacentVertex] != 0 &&
                    distances[currentVertex] != Int.MAX_VALUE &&
                    distances[currentVertex] + graph[currentVertex][adjacentVertex] < distances[adjacentVertex]
                ) {
                    distances[adjacentVertex] = distances[currentVertex] + graph[currentVertex][adjacentVertex]
                }
            }
        }

        return distances
    }

    private fun getMinimumDistanceVertex(distances: IntArray, shortestPathTreeSet: BooleanArray): Int {
        var minimumDistance = Int.MAX_VALUE
        var minimumDistanceIndex = -1

        for (vertex in 0..<numberOfVertices) {
            if (!shortestPathTreeSet[vertex] && distances[vertex] <= minimumDistance) {
                minimumDistance = distances[vertex]
                minimumDistanceIndex = vertex
            }
        }

        return minimumDistanceIndex
    }
}
