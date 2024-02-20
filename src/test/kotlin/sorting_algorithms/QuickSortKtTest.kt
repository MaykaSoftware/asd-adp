package sorting_algorithms

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class QuickSortKtTest {
    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    @Test
    fun quickSortPerformance() {
        testQuickSortPerformance(deserializedData.lijstAflopend2, "lijstAflopend2")
        testQuickSortPerformance(deserializedData.lijstGesorteerdAflopend3, "lijstGesorteerdAflopend3")
        testQuickSortPerformance(deserializedData.lijstHerhaald1000, "lijstHerhaald1000")
        testQuickSortPerformance(deserializedData.lijstOplopend2, "lijstOplopend2")
        testQuickSortPerformance(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3")
        testQuickSortPerformance(deserializedData.lijstNull3, "lijstNull3")
        testQuickSortPerformance(deserializedData.lijstOplopend10000, "lijstOplopend10000")
        testQuickSortPerformance(deserializedData.lijstWillekeurig10000, "lijstWillekeurig10000")
        testQuickSortPerformance(deserializedData.lijstLeeg0, "lijstLeeg0")
        testQuickSortPerformance(deserializedData.lijstWillekeurig3, "lijstWillekeurig3")
    }

    private inline fun <reified T : Comparable<T>> testQuickSortPerformance(list: List<T>, name: String) {
        val array = list.toTypedArray()

        val sortingTime = measureNanoTime {
            quicksort(array, 0, array.size - 1)
        }

        println("Time taken to sort $name using quicksort: $sortingTime ns")
    }
}