package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class PriorityQueueTest {
    private val dynamicArray = DynamicArray<Int>()

    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    var lijst_aflopend_2 = PriorityQueue<Int>()
    var lijst_gesorteerd_aflopend_3 = PriorityQueue<Int>()
    var lijst_herhaald_1000 = PriorityQueue<Int>()
    var lijst_oplopend_2 = PriorityQueue<Int>()
    var lijst_onsorteerbaar_3 = PriorityQueue<Double>()
    var lijst_float_8001 = PriorityQueue<Double>()
    var lijst_leeg_0 = PriorityQueue<Int>()
    var lijst_null_3 = PriorityQueue<Int>()
    var lijst_oplopend_10000 = PriorityQueue<Int>()
    var lijst_willekeurig_10000 = PriorityQueue<Int>()
    var lijst_willekeurig_3 = PriorityQueue<Int>()

    @BeforeEach
    fun init() {
        lijst_aflopend_2.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstAflopend2))
        lijst_gesorteerd_aflopend_3.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstGesorteerdAflopend3))
        lijst_herhaald_1000.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstHerhaald1000))
        lijst_oplopend_2.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstOplopend2))
        lijst_onsorteerbaar_3.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstOnsorteerbaar3))
        lijst_float_8001.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstFloat8001))
        lijst_leeg_0.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstLeeg0))
        lijst_null_3.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstNull3))
        lijst_oplopend_10000.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstOplopend10000))
        lijst_willekeurig_10000.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstWillekeurig10000))
        lijst_willekeurig_3.addAll(dynamicArray.listToDynamicArray(deserializedData.lijstWillekeurig3))
    }

    @Test
    fun add() {
        val addTimelijst_aflopend_2 = measureNanoTime {
            lijst_aflopend_2
        }
        println("Time taken addTimelijst_aflopend_2 $addTimelijst_aflopend_2 ns")
        val addTimelijst_gesorteerd_aflopend_3 = measureNanoTime {
            lijst_gesorteerd_aflopend_3
        }
        println("Time taken addTimelijst_gesorteerd_aflopend_3 $addTimelijst_gesorteerd_aflopend_3 ns")
        val addTimelijst_herhaald_1000 = measureNanoTime {
            lijst_herhaald_1000
        }
        println("Time taken addTimelijst_herhaald_1000 $addTimelijst_herhaald_1000 ns")
        val addTimelijst_oplopend_2 = measureNanoTime {
            lijst_oplopend_2
        }
        println("Time taken addTimelijst_oplopend_2 $addTimelijst_oplopend_2 ns")
        val addTimelijst_onsorteerbaar_3 = measureNanoTime {
            lijst_onsorteerbaar_3
        }
        println("Time taken addTimelijst_onsorteerbaar_3 $addTimelijst_onsorteerbaar_3 ns")
        val addTimelijst_float_8001 = measureNanoTime {
            lijst_float_8001
        }
        println("Time taken addTimelijst_float_8001 $addTimelijst_float_8001 ns")
        val addTimelijst_leeg_0 = measureNanoTime {
            lijst_leeg_0
        }
        println("Time taken addTimelijst_leeg_0 $addTimelijst_leeg_0 ns")
        val addTimelijst_null_3 = measureNanoTime {
            lijst_null_3
        }
        println("Time taken addTimelijst_null_3 $addTimelijst_null_3 ns")
        val addTimelijst_oplopend_10000 = measureNanoTime {
            lijst_oplopend_10000
        }
        println("Time taken addTimelijst_oplopend_10000 $addTimelijst_oplopend_10000 ns")
        val addTimelijst_willekeurig_10000 = measureNanoTime {
            lijst_willekeurig_10000
        }
        println("Time taken addTimelijst_willekeurig_10000 $addTimelijst_willekeurig_10000 ns")
        val addTimelijst_willekeurig_3 = measureNanoTime {
            lijst_willekeurig_3
        }
        println("Time taken addTimelijst_willekeurig_3 $addTimelijst_willekeurig_3 ns")

    }

    @Test
    fun peek() {
        val lijst_aflopend_2PeekTime = measureNanoTime {
            val topElement = lijst_aflopend_2.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_aflopend_2PeekTime ns")

        val lijst_gesorteerd_aflopend_3PeekTime = measureNanoTime {
            val topElement = lijst_gesorteerd_aflopend_3.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_gesorteerd_aflopend_3PeekTime ns")

        val lijst_herhaald_1000PeekTime = measureNanoTime {
            val topElement = lijst_herhaald_1000.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_herhaald_1000PeekTime ns")

        val lijst_oplopend_2PeekTime = measureNanoTime {
            val topElement = lijst_oplopend_2.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_oplopend_2PeekTime ns")

        val lijst_onsorteerbaar_3PeekTime = measureNanoTime {
            val topElement = lijst_onsorteerbaar_3.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_onsorteerbaar_3PeekTime ns")

        val lijst_float_8001PeekTime = measureNanoTime {
            val topElement = lijst_float_8001.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_float_8001PeekTime ns")

        val lijst_null_3PeekTime = measureNanoTime {
            val topElement = lijst_null_3.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_null_3PeekTime ns")

        val lijst_oplopend_10000PeekTime = measureNanoTime {
            val topElement = lijst_oplopend_10000.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_oplopend_10000PeekTime ns")

        val lijst_willekeurig_10000PeekTime = measureNanoTime {
            val topElement = lijst_willekeurig_10000.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_willekeurig_10000PeekTime ns")

        val lijst_willekeurig_3PeekTime = measureNanoTime {
            val topElement = lijst_willekeurig_3.peek()
            println("Top element in the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_willekeurig_3PeekTime ns")
    }

    @Test
    fun poll() {
        val lijst_aflopend_2PeekTime = measureNanoTime {
            val topElement = lijst_aflopend_2.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_aflopend_2PeekTime ns")

        val lijst_gesorteerd_aflopend_3PeekTime = measureNanoTime {
            val topElement = lijst_gesorteerd_aflopend_3.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for peek: $lijst_gesorteerd_aflopend_3PeekTime ns")

        val lijst_herhaald_1000pollTime = measureNanoTime {
            val topElement = lijst_herhaald_1000.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_herhaald_1000pollTime ns")

        val lijst_oplopend_2pollTime = measureNanoTime {
            val topElement = lijst_oplopend_2.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_oplopend_2pollTime ns")

        val lijst_onsorteerbaar_3pollTime = measureNanoTime {
            val topElement = lijst_onsorteerbaar_3.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_onsorteerbaar_3pollTime ns")

        val lijst_float_8001pollTime = measureNanoTime {
            val topElement = lijst_float_8001.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_float_8001pollTime ns")

        val lijst_leeg_0pollTime = measureNanoTime {
            val topElement = lijst_leeg_0.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_leeg_0pollTime ns")

        val lijst_null_3pollTime = measureNanoTime {
            val topElement = lijst_null_3.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_null_3pollTime ns")

        val lijst_oplopend_10000pollTime = measureNanoTime {
            val topElement = lijst_oplopend_10000.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_oplopend_10000pollTime ns")

        val lijst_willekeurig_10000pollTime = measureNanoTime {
            val topElement = lijst_willekeurig_10000.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_willekeurig_10000pollTime ns")

        val lijst_willekeurig_3pollTime = measureNanoTime {
            val topElement = lijst_willekeurig_3.poll()
            println("Removed element from the priority queue: $topElement")
        }
        println("Time taken for poll: $lijst_willekeurig_3pollTime ns")
    }
}