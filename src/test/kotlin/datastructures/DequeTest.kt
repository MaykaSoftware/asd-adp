package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class DequeTest {

    private val jsonString = readResourceFile("dataset_sorteren.json")
    private val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    private var lijstOplopend10000 = doublyLinkedListToDeque(deserializedData.lijstOplopend10000)
    private var lijstLeeg0 = doublyLinkedListToDeque(deserializedData.lijstLeeg0)

    private var lijstAflopend2 = doublyLinkedListToDeque(deserializedData.lijstAflopend2)
    private var lijstGesorteerdAflopend3 = doublyLinkedListToDeque(deserializedData.lijstGesorteerdAflopend3)
    private var lijstHerhaald1000 = doublyLinkedListToDeque(deserializedData.lijstHerhaald1000)
    private var lijstOplopend2 = doublyLinkedListToDeque(deserializedData.lijstOplopend2)
    private var lijstOnsorteerbaar3 = doublyLinkedListToDeque(deserializedData.lijstOnsorteerbaar3)
    private var lijstFloat8001 = doublyLinkedListToDeque(deserializedData.lijstFloat8001)
    private var lijstNull1 = doublyLinkedListToDeque(deserializedData.lijstNull1)
    private var lijstNull3 = doublyLinkedListToDeque(deserializedData.lijstNull3)
    private var lijstWillekeurig10000 = doublyLinkedListToDeque(deserializedData.lijstWillekeurig10000)
    private var lijstWillekeurig3 = doublyLinkedListToDeque(deserializedData.lijstWillekeurig3)

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun testAddFirstPerformance() {

        val timeInNanos = measureNanoTime {
            lijstOplopend10000.addFirst(0)
        }

        println("Time taken to addFirst  $timeInNanos ns")
    }

    @Test
    fun testAddLastPerformance() {
        val timeInNanos = measureNanoTime {
            lijstOplopend10000.addLast(10_001)
        }

        println("Time taken to addLast $timeInNanos ns")
    }

    @Test
    fun testRemoveFirstPerformance() {
        val timeInNanos = measureNanoTime {
            lijstOplopend10000.removeFirst()
        }

        println("Time taken to removeFirst $timeInNanos ns")
    }

    @Test
    fun testRemoveLastPerformance() {
        val timeInNanos = measureNanoTime {
            lijstOplopend10000.removeLast()
        }

        println("Time taken to removeLast $timeInNanos ns")
    }
}