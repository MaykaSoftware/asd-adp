package sorting_algorithms

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class InsertionSortKtTest {
    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    @Test
    fun insertionSortPerformance() {
        testInsertionSortPerformance(deserializedData.lijstAflopend2, "lijstAflopend2")
        testInsertionSortPerformance(deserializedData.lijstGesorteerdAflopend3, "lijstGesorteerdAflopend3")
        testInsertionSortPerformance(deserializedData.lijstHerhaald1000, "lijstHerhaald1000")
        testInsertionSortPerformance(deserializedData.lijstOplopend2, "lijstOplopend2")
        testInsertionSortPerformance(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3")
        testInsertionSortPerformance(deserializedData.lijstNull3, "lijstNull3")
        testInsertionSortPerformance(deserializedData.lijstOplopend10000, "lijstOplopend10000")
        testInsertionSortPerformance(deserializedData.lijstWillekeurig10000, "lijstWillekeurig10000")
        testInsertionSortPerformance(deserializedData.lijstLeeg0, "lijstLeeg0")
        testInsertionSortPerformance(deserializedData.lijstWillekeurig3, "lijstWillekeurig3")
    }

    private inline fun <reified T : Comparable<T>> testInsertionSortPerformance(list: List<T>, name: String) {
        val array = list.toTypedArray()

        val sortingTime = measureNanoTime {
            insertionSort(array)
        }

        println("Time taken to sort $name using insertionSort: $sortingTime ns")
    }
}