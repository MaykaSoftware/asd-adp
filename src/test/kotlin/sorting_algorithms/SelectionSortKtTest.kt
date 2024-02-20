package sorting_algorithms

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class SelectionSortKtTest {
    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    @Test
    fun selectionSortPerformance() {
        testSelectionSortPerformance(deserializedData.lijstAflopend2, "lijstAflopend2")
        testSelectionSortPerformance(deserializedData.lijstGesorteerdAflopend3, "lijstGesorteerdAflopend3")
        testSelectionSortPerformance(deserializedData.lijstHerhaald1000, "lijstHerhaald1000")
        testSelectionSortPerformance(deserializedData.lijstOplopend2, "lijstOplopend2")
        testSelectionSortPerformance(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3")
        testSelectionSortPerformance(deserializedData.lijstNull3, "lijstNull3")
        testSelectionSortPerformance(deserializedData.lijstOplopend10000, "lijstOplopend10000")
        testSelectionSortPerformance(deserializedData.lijstWillekeurig10000, "lijstWillekeurig10000")
        testSelectionSortPerformance(deserializedData.lijstLeeg0, "lijstLeeg0")
        testSelectionSortPerformance(deserializedData.lijstWillekeurig3, "lijstWillekeurig3")
    }

    private inline fun <reified T : Comparable<T>> testSelectionSortPerformance(list: List<T>, name: String) {
        val array = list.toTypedArray()

        val sortingTime = measureNanoTime {
            selectionSort(array)
        }

        println("Time taken to sort $name using selectionSort: $sortingTime ns")
    }
}