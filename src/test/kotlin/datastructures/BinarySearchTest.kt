package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Sorteren
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class BinarySearchTest {
    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    private fun <T : Comparable<T>> addAllToList(list: List<T>, name: String) {
        val binarySearchTree = BinarySearch<T>()
        val addAll = measureNanoTime {
            for (element in list) {
                binarySearchTree.add(element)
            }
        }
        println("Time taken to add all elements of $name: $addAll ns")
    }

    @Test
    fun add() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.add(element)
        }
    }


    @Test
    fun find() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.find(element)
        }
    }

    @Test
    fun remove() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.remove(element)
        }
    }

    @Test
    fun getTreeDepth() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.getTreeDepth()
        }
    }

    @Test
    fun traversePreOrder() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.traversePreOrder(binarySearchTree.root)
        }
    }

    @Test
    fun traverseInOrder() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.traverseInOrder(binarySearchTree.root)
        }
    }

    @Test
    fun traversePostOrder() {
        testBinarySearchTree(deserializedData.lijstAflopend2, "lijstAflopend2") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstGesorteerdAflopend3,
            "lijstGesorteerdAflopend3"
        ) { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstHerhaald1000, "lijstHerhaald1000") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend2, "lijstOplopend2") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOnsorteerbaar3, "lijstOnsorteerbaar3") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstLeeg0, "lijstLeeg0") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstNull3, "lijstNull3") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstOplopend10000, "lijstOplopend10000") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(
            deserializedData.lijstWillekeurig10000,
            "lijstWillekeurig10000"
        ) { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
        testBinarySearchTree(deserializedData.lijstWillekeurig3, "lijstWillekeurig3") { binarySearchTree, element ->
            binarySearchTree.traversePostOrder(binarySearchTree.root)
        }
    }

    private fun <T : Comparable<T>> testBinarySearchTree(
        list: List<T>,
        name: String,
        testBlock: (BinarySearch<T>, T) -> Unit
    ) {
        val binarySearchTree = BinarySearch<T>()
        addAllToList(list, name)

        val operationTime = measureNanoTime {
            for (element in list) {
                testBlock(binarySearchTree, element)
            }
        }
        println("Time taken to perform operations on $name: $operationTime ns")
    }
}