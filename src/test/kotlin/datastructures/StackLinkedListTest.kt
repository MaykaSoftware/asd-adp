package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile

import kotlin.system.measureNanoTime

class StackLinkedListTest {
    private val jsonString = readResourceFile("dataset_sorteren.json")
    private val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    private var lijstOplopend10000 = linkedListToStack(deserializedData.lijstOplopend10000)
    private var lijstLeeg0 = linkedListToStack(deserializedData.lijstLeeg0)

    private var lijstAflopend2 = linkedListToStack(deserializedData.lijstAflopend2)
    private var lijstGesorteerdAflopend3 = linkedListToStack(deserializedData.lijstGesorteerdAflopend3)
    private var lijstHerhaald1000 = linkedListToStack(deserializedData.lijstHerhaald1000)
    private var lijstOplopend2 = linkedListToStack(deserializedData.lijstOplopend2)
    private var lijstOnsorteerbaar3 = linkedListToStack(deserializedData.lijstOnsorteerbaar3)
    private var lijstFloat8001 = linkedListToStack(deserializedData.lijstFloat8001)
    private var lijstNull1 = linkedListToStack(deserializedData.lijstNull1)
    private var lijstNull3 = linkedListToStack(deserializedData.lijstNull3)
    private var lijstWillekeurig10000 = linkedListToStack(deserializedData.lijstWillekeurig10000)
    private var lijstWillekeurig3 = linkedListToStack(deserializedData.lijstWillekeurig3)

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun push() {
        val pushTime = measureNanoTime {
            lijstOplopend10000.push(10_001)
        }
        println("Time taken to push element: $pushTime ns")
    }

    @Test
    fun pop() {
        val popTime = measureNanoTime {
            lijstOplopend10000.pop()
        }
        println("Time taken to pop element: $popTime ns")
    }

    @Test
    fun peek() {
        val peekTime = measureNanoTime {
            lijstOplopend10000.peek()
        }
        println("Time taken to peek 1: $peekTime ns")
    }

    @Test
    fun search() {
        val searchTime = measureNanoTime {
            lijstOplopend10000.search(5000)
        }
        println("Time taken to search for an element: $searchTime ns")
    }

    @Test
    fun add10Elements() {
        lijstLeeg0.clearAll()
        val add10Elements = measureNanoTime {
            repeat(10) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 10 elements: $add10Elements ns")
    }

    @Test
    fun add100Elements() {
        lijstLeeg0.clearAll()
        val add100Elements = measureNanoTime {
            repeat(100) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 100 elements: $add100Elements ns")
    }

    @Test
    fun add1_000Elements() {
        lijstLeeg0.clearAll()
        val add1_000Elements = measureNanoTime {
            repeat(1000) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 1000 elements: $add1_000Elements ns")
    }

    @Test
    fun add10_000Elements() {
        lijstLeeg0.clearAll()
        val add10_000Elements = measureNanoTime {
            repeat(10000) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 10000 elements: $add10_000Elements ns")
    }

    @Test
    fun add100_000Elements() {
        lijstLeeg0.clearAll()
        val add100_000Elements = measureNanoTime {
            repeat(100000) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 100000 elements: $add100_000Elements ns")
    }

    @Test
    fun add1_000_000Elements() {
        lijstLeeg0.clearAll()
        val add1_000_000Elements = measureNanoTime {
            repeat(1000000) {
                lijstLeeg0.push(it)
            }
        }
        println("Time taken to add 1000000 elements: $add1_000_000Elements ns")
    }
}