package sorting_algorithms

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.Test

import util.readResourceFile
import kotlin.system.measureNanoTime

class ParallelMergeSortKtTest {
    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    @Test
    fun parallelMergeSortPerformance() {
        testParallelMergeSortPerformance(deserializedData.lijstAflopend2, "lijstAflopend2")
        testParallelMergeSortPerformance(deserializedData.lijstGesorteerdAflopend3, "lijstGesorteerdAflopend3")
        testParallelMergeSortPerformance(deserializedData.lijstHerhaald1000, "lijstHerhaald1000")
        testParallelMergeSortPerformance(deserializedData.lijstOplopend2, "lijstOplopend2")
        testParallelMergeSortPerformance(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3")
        testParallelMergeSortPerformance(deserializedData.lijstNull3, "lijstNull3")
        testParallelMergeSortPerformance(deserializedData.lijstOplopend10000, "lijstOplopend10000")
        testParallelMergeSortPerformance(deserializedData.lijstWillekeurig10000, "lijstWillekeurig10000")
        testParallelMergeSortPerformance(deserializedData.lijstLeeg0, "lijstLeeg0")
        testParallelMergeSortPerformance(deserializedData.lijstWillekeurig3, "lijstWillekeurig3")
    }

    private inline fun <reified T : Comparable<T>> testParallelMergeSortPerformance(list: List<T>, name: String) {
        val array = list.toTypedArray()

        val sortingTime = measureNanoTime {
            parallelMergeSort(array)
        }

        println("Time taken to sort $name using parallelMergeSort: $sortingTime ns")
    }

}