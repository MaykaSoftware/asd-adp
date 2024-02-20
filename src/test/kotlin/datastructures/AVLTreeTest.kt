package datastructures

import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AVLTreeTest {

    @Test
    fun find() {
        val avlTree = AVLTree()
        avlTree.insert(10)
        avlTree.insert(5)
        avlTree.insert(15)

        val foundNode = avlTree.find(5)

        assertEquals(5, foundNode?.value)
    }

    @Test
    fun findMin() {
        val avlTree = AVLTree()
        avlTree.insert(10)
        avlTree.insert(5)
        avlTree.insert(15)

        val minNode = avlTree.findMin()

        assertEquals(5, minNode?.value)
    }

    @Test
    fun findMax() {
        val avlTree = AVLTree()
        avlTree.insert(10)
        avlTree.insert(5)
        avlTree.insert(15)

        val maxNode = avlTree.findMax()

        assertEquals(15, maxNode?.value)
    }

    @Test
    fun insert() {
        val avlTree = AVLTree()
        avlTree.insert(10)
        avlTree.insert(5)
        avlTree.insert(15)

        val foundNode = avlTree.find(10)

        assertEquals(10, foundNode?.value)
    }

    @Test
    fun remove() {
        val avlTree = AVLTree()
        avlTree.insert(10)
        avlTree.insert(5)
        avlTree.insert(15)

        avlTree.remove(5)

        val foundNode = avlTree.find(5)

        assertNull(foundNode)
    }

    @Test
    fun performanceTest() {
        val avlTree = AVLTree()

        val insertionTime = measureNanoTime {
            for (i in 1..10000) {
                avlTree.insert(i)
            }
        }

        val searchTime = measureNanoTime {
            val foundNode = avlTree.find(5000)
            assertEquals(5000, foundNode?.value)
        }

        val removalTime = measureNanoTime {
            avlTree.remove(5000)
        }

        println("Insertion time: $insertionTime nanoseconds")
        println("Search time: $searchTime nanoseconds")
        println("Removal time: $removalTime nanoseconds")
    }
}
