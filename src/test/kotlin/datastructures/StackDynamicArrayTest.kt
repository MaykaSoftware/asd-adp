package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class StackDynamicArrayTest {

    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    var lijst_oplopend_10000 = dynamicArrayToStack(deserializedData.lijstOplopend10000)

    var lijst_aflopend_2 = dynamicArrayToStack(deserializedData.lijstAflopend2)
    var lijst_gesorteerd_aflopend_3 = dynamicArrayToStack(deserializedData.lijstGesorteerdAflopend3)
    var lijst_herhaald_1000 = dynamicArrayToStack(deserializedData.lijstHerhaald1000)
    var lijst_oplopend_2 = dynamicArrayToStack(deserializedData.lijstOplopend2)
    var lijst_onsorteerbaar_3 = dynamicArrayToStack(deserializedData.lijstOnsorteerbaar3)
    var lijst_float_8001 = dynamicArrayToStack(deserializedData.lijstFloat8001)
    var lijst_leeg_0 = dynamicArrayToStack(deserializedData.lijstLeeg0)
    var lijst_null_1 = dynamicArrayToStack(deserializedData.lijstNull1)
    var lijst_null_3 = dynamicArrayToStack(deserializedData.lijstNull3)
    var lijst_willekeurig_10000 = dynamicArrayToStack(deserializedData.lijstWillekeurig10000)
    var lijst_willekeurig_3 = dynamicArrayToStack(deserializedData.lijstWillekeurig3)

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun push() {
        val pushTime = measureNanoTime {
            lijst_oplopend_10000.push(10_001)
        }
        println("Time taken to push element: $pushTime ns")
    }

    @Test
    fun pop() {
        val popTime = measureNanoTime {
            lijst_oplopend_10000.pop()
        }
        println("Time taken to pop element: $popTime ns")
    }

    @Test
    fun peek() {
        val peekTime = measureNanoTime {
            lijst_oplopend_10000.peek()
        }
        println("Time taken to peek 1: $peekTime ns")
    }

    @Test
    fun search() {
        val searchTime = measureNanoTime {
            lijst_oplopend_10000.search(5000)
        }
        println("Time taken to search for an element: $searchTime ns")
    }
}