import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.GraphData
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class GraphTest {
    val jsonString = readResourceFile("dataset_grafen.json")
    val deserializedData = Json.decodeFromString<GraphData>(jsonString)

    @Test
    fun addVertex() {
        val graph = Graph<Int>()

        val addVertexTime = measureNanoTime {
            deserializedData.lijnlijst.flatten().distinct().forEach { vertex ->
                val addVertexOperationTime = measureNanoTime {
                    graph.addVertex(vertex)
                }
                println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
            }

            deserializedData.lijnlijst_gewogen.flatten().distinct().forEach { vertex ->
                val addVertexOperationTime = measureNanoTime {
                    graph.addVertex(vertex)
                }
                println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
            }

            deserializedData.verbindingslijst.flatten().distinct().forEach { vertex ->
                val addVertexOperationTime = measureNanoTime {
                    graph.addVertex(vertex)
                }
                println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
            }

            deserializedData.verbindingsmatrix.flatten().distinct().forEach { vertex ->
                val addVertexOperationTime = measureNanoTime {
                    graph.addVertex(vertex)
                }
                println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
            }

            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    edge.forEach { vertex ->
                        val addVertexOperationTime = measureNanoTime {
                            graph.addVertex(vertex)
                        }
                        println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
                    }
                }
            }
        }

        println("Total AddVertex operation time: $addVertexTime ns")
    }

    @Test
    fun addEdge() {
        val graph = Graph<Int>()

        val addEdgesTime = measureNanoTime {
            deserializedData.lijnlijst.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }

            deserializedData.lijnlijst_gewogen.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }

            deserializedData.verbindingsmatrix.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        // Assuming a default weight of 1 for simplicity
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }

            deserializedData.verbindingslijst.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }

            deserializedData.verbindingsmatrix_gewogen.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }

            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    if (edge.size >= 2) {
                        val source = edge[0]
                        val destination = edge[1]
                        val weight = edge.getOrNull(2) ?: 1
                        val addEdgeOperationTime = measureNanoTime {
                            graph.addEdge(source, destination, weight)
                        }
                        println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                    }
                }
            }
        }

        println("Total AddEdge operation time: $addEdgesTime ns")
    }

    @Test
    fun removeVertex() {
        val graph = Graph<Int>()

        val addVertexTime = measureNanoTime {
            deserializedData.lijnlijst.flatten().distinct().forEach { vertex ->
                val addVertexOperationTime = measureNanoTime {
                    graph.addVertex(vertex)
                }
                println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
            }
        }

        println("AddVertex operation time: $addVertexTime ns")

        val vertexToRemove = 1

        val removeVertexTime = measureNanoTime {
            graph.removeVertex(vertexToRemove)
        }

        println("RemoveVertex operation time: $removeVertexTime ns")

        val addVertexTimeAfterRemove = measureNanoTime {
            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    edge.forEach { vertex ->
                        val addVertexOperationTime = measureNanoTime {
                            graph.addVertex(vertex)
                        }
                        println("AddVertex operation time for vertex $vertex: $addVertexOperationTime ns")
                    }
                }
            }
        }

        println("AddVertex operation time after remove: $addVertexTimeAfterRemove ns")

        val removeVertexTimeAfterAdd = measureNanoTime {
            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    edge.forEach { vertex ->
                        val removeVertexOperationTime = measureNanoTime {
                            graph.removeVertex(vertex)
                        }
                        println("RemoveVertex operation time for vertex $vertex: $removeVertexOperationTime ns")
                    }
                }
            }
        }

        println("RemoveVertex operation time after add: $removeVertexTimeAfterAdd ns")
    }

    @Test
    fun removeEdge() {
        val graph = Graph<Int>()

        val addEdgesTime = measureNanoTime {
            deserializedData.lijnlijst.forEach { edge ->
                if (edge.size == 2) {
                    val addEdgeOperationTime = measureNanoTime {
                        graph.addEdge(edge[0], edge[1], 1)
                    }
                    println("AddEdge operation time for edge $edge: $addEdgeOperationTime ns")
                }
            }
        }

        println("AddEdges operation time: $addEdgesTime ns")

        val source = 0
        val destination = 1

        val removeEdgeTime = measureNanoTime {
            graph.removeEdge(source, destination)
        }

        println("RemoveEdge operation time: $removeEdgeTime ns")

        val addEdgesTimeAfterRemove = measureNanoTime {
            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    edge.forEach { vertex ->
                        val addEdgeOperationTime = measureNanoTime {
                            graph.addEdge(vertex, destination, 1)
                        }
                        println("AddEdge operation time for edge [$vertex, $destination]: $addEdgeOperationTime ns")
                    }
                }
            }
        }

        println("AddEdges operation time after remove: $addEdgesTimeAfterRemove ns")

        val removeEdgesTimeAfterAdd = measureNanoTime {
            deserializedData.verbindingslijst_gewogen.forEach { edges ->
                edges.forEach { edge ->
                    if (edge.size == 2) {
                        val removeEdgeOperationTime = measureNanoTime {
                            graph.removeEdge(edge[0], edge[1])
                        }
                        println("RemoveEdge operation time for edge $edge: $removeEdgeOperationTime ns")
                    }
                }
            }
        }

        println("RemoveEdges operation time after add: $removeEdgesTimeAfterAdd ns")
    }

    @Test
    fun getAdjacencyList() {
        val graph = Graph<Int>()

        val addEdgesTime = measureNanoTime {
            deserializedData.lijnlijst.forEach { edge ->
                if (edge.size == 2) {
                    graph.addEdge(edge[0], edge[1], 1)
                }
            }
        }

        println("AddEdges operation time: $addEdgesTime ns")

        val adjacencyListTime = measureNanoTime {
            graph.getAdjacencyList()
        }

        println("GetAdjacencyList operation time: $adjacencyListTime ns")
    }

    @Test
    fun getEdgeList() {
        val graph = Graph<Int>()

        val addEdgesTime = measureNanoTime {
            deserializedData.lijnlijst.forEach { edge ->
                if (edge.size == 2) {
                    graph.addEdge(edge[0], edge[1], 1)
                }
            }
        }

        println("AddEdges operation time: $addEdgesTime ns")

        val edgeListTime = measureNanoTime {
            graph.getEdgeList()
        }

        println("GetEdgeList operation time: $edgeListTime ns")
    }
}
