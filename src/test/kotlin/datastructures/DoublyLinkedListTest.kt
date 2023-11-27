package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class DoublyLinkedListTests {
    private val doublyLinkedList = DoublyLinkedList<Int>()

    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    var lijst_aflopend_2 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstAflopend2)
    var lijst_gesorteerd_aflopend_3 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstGesorteerdAflopend3)
    var lijst_herhaald_1000 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstHerhaald1000)
    var lijst_oplopend_2 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstOplopend2)
    var lijst_onsorteerbaar_3 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstOnsorteerbaar3)
    var lijst_float_8001 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstFloat8001)
    var lijst_leeg_0 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstLeeg0)
    var lijst_null_1 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstNull1)
    var lijst_null_3 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstNull3)
    var lijst_oplopend_10000 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstOplopend10000)
    var lijst_willekeurig_10000 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstWillekeurig10000)
    var lijst_willekeurig_3 = doublyLinkedList.listToDoublyLinkedList(deserializedData.lijstWillekeurig3)

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun push() {
        val addFirstTime = measureNanoTime {
            lijst_oplopend_10000.push(1)
        }
        println("Time taken to push 1 element: $addFirstTime ns")
    }

    @Test
    fun append() {
        val addLastTime = measureNanoTime {
            lijst_oplopend_10000.append(1)
        }
        println("Time taken to append 1 element: $addLastTime ns")
    }

    @Test
    fun insert() {
        lijst_oplopend_10000.insert(5_000, 5_000)

        val insertTime = measureNanoTime {
            lijst_oplopend_10000.insert(1, 2)
        }
        println("Time taken to insert 1 element at index 5000: $insertTime ns")
    }

    @Test
    fun pop() {
        val removeFirstTime = measureNanoTime {
            lijst_oplopend_10000.pop()
        }
        println("Time taken to pop an element: $removeFirstTime ns")
    }

    @Test
    fun removeLast() {
        val removeLastTime = measureNanoTime {
            lijst_oplopend_10000.removeLast()
        }
        println("Time taken to removeLast element: $removeLastTime ns")
    }

    @Test
    fun remove() {
        val removeTime = measureNanoTime {
            lijst_oplopend_10000.remove(5_000)
        }
        println("Time taken to remove an element at index 5000: $removeTime ns")
    }

    @Test
    fun getFirst() {
        val getFirstTime = measureNanoTime {
            lijst_oplopend_10000.first
        }
        println("Time taken to getFirst element: $getFirstTime ns")
    }

    @Test
    fun getLast() {
        val getLastTime = measureNanoTime {
            lijst_oplopend_10000.last
        }
        println("Time taken to getLast element: $getLastTime ns")
    }

    @Test
    fun add10Elements() {
        val add10Elements = measureNanoTime {
            repeat(10) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 10 elements: $add10Elements ns")
    }

    @Test
    fun add100Elements() {
        lijst_leeg_0.clearAll()
        val add100Elements = measureNanoTime {
            repeat(100) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 100 elements: $add100Elements ns")
    }

    @Test
    fun add1_000Elements() {
        lijst_leeg_0.clearAll()
        val add1000Elements = measureNanoTime {
            repeat(1000) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 1_000 elements: $add1000Elements ns")
    }

    @Test
    fun add10_000Elements() {
        lijst_leeg_0.clearAll()
        val add10000Elements = measureNanoTime {
            repeat(10000) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 10_000 elements: $add10000Elements ns")
    }

    @Test
    fun add100_000Elements() {
        lijst_leeg_0.clearAll()
        val add100000Elements = measureNanoTime {
            repeat(100000) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 100_000 elements: $add100000Elements ns")
    }

    @Test
    fun add1_000_000Elements() {
        lijst_leeg_0.clearAll()
        val add1000000Elements = measureNanoTime {
            repeat(1000000) {
                lijst_leeg_0.push(it)
            }
        }
        println("Time taken to push 1_000_000 elements: $add1000000Elements ns")
    }
}

