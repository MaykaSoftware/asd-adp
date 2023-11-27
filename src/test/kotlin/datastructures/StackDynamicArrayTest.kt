package datastructures

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class StackDynamicArrayTest {
    val stack = StackDynamicArray<Int>()

    @BeforeEach
    fun setUp() {
        for (i in 1..1_000) {
            stack.push(i)
        }

    }

    @Test
    fun push() {
        val pushTime = measureNanoTime {
            stack.push(1_001)
        }
        println("Time taken to push element: $pushTime ns")
    }

    @Test
    fun pop() {
        val popTime = measureNanoTime {
            stack.pop()
        }
        println("Time taken to pop element: $popTime ns")
    }

    @Test
    fun peek() {
        val peekTime = measureNanoTime {
            stack.peek()
        }
        println("Time taken to peek 1: $peekTime ns")
    }

    @Test
    fun search() {
        val searchTime = measureNanoTime {
            stack.search(500)
        }
        println("Time taken to search for an element: $searchTime ns")
    }

    @Test
    fun add10Elements() {
        val stack = StackDynamicArray<Int>()
        val add10Elements = measureNanoTime {
            repeat(10) {
                stack.push(it)
            }
        }
        println("Time taken to add 10 elements: $add10Elements ns")
    }

    @Test
    fun add100Elements() {
        val stack = StackDynamicArray<Int>()
        val add100Elements = measureNanoTime {
            repeat(100) {
                stack.push(it)
            }
        }
        println("Time taken to add 100 elements: $add100Elements ns")
    }

    @Test
    fun add1_000Elements() {
        val stack = StackDynamicArray<Int>()
        val add1_000Elements = measureNanoTime {
            repeat(1000) {
                stack.push(it)
            }
        }
        println("Time taken to add 1000 elements: $add1_000Elements ns")
    }

    @Test
    fun add10_000Elements() {
        val stack = StackDynamicArray<Int>()
        val add10_000Elements = measureNanoTime {
            repeat(10000) {
                stack.push(it)
            }
        }
        println("Time taken to add 10000 elements: $add10_000Elements ns")
    }

    @Test
    fun add100_000Elements() {
        val stack = StackDynamicArray<Int>()
        val add100_000Elements = measureNanoTime {
            repeat(100000) {
                stack.push(it)
            }
        }
        println("Time taken to add 100000 elements: $add100_000Elements ns")
    }

    @Test
    fun add1_000_000Elements() {
        val stack = StackDynamicArray<Int>()
        val add1_000_000Elements = measureNanoTime {
            repeat(1000000) {
                stack.push(it)
            }
        }
        println("Time taken to add 1000000 elements: $add1_000_000Elements ns")
    }
}