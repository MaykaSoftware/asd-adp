class Graph<T> {
    private val adjacencyList: MutableMap<T, MutableList<Pair<T, Int>>> = mutableMapOf()

    fun addVertex(vertex: T) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList[vertex] = mutableListOf()
        }
    }

    fun addEdge(source: T, destination: T, weight: Int) {
        addVertex(source)
        addVertex(destination)
        adjacencyList[source]!!.add(Pair(destination, weight))
        adjacencyList[destination]!!.add(Pair(source, weight)) // For an undirected graph
    }

    fun removeVertex(vertex: T) {
        adjacencyList.remove(vertex)
        adjacencyList.values.forEach { edges -> edges.removeIf { it.first == vertex } }
    }

    fun removeEdge(source: T, destination: T) {
        adjacencyList[source]?.removeIf { it.first == destination }
        adjacencyList[destination]?.removeIf { it.first == source }
    }

    fun getAdjacencyList(): Map<T, List<Pair<T, Int>>> {
        return adjacencyList.toMap()
    }

    fun getEdgeList(): List<Triple<T, T, Int>> {
        val edgeList = mutableListOf<Triple<T, T, Int>>()
        for ((source, neighbors) in adjacencyList) {
            for ((destination, weight) in neighbors) {
                edgeList.add(Triple(source, destination, weight))
            }
        }
        return edgeList
    }
}
