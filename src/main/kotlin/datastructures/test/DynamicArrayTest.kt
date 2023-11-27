package datastructures.test

import datastructures.DynamicArray
import kotlin.system.measureNanoTime

class DynamicArrayTest {
    val dynamicArray = DynamicArray<Int>()


    fun add1MillionTest() {

        // Measure time taken to add 1 million elements
        val addTime = measureNanoTime {
            repeat(1_000_000) {
                dynamicArray.add(it)
            }
        }
        println("Time taken to add 1 million elements: $addTime ns")
    }

    fun insertElementAtFirstIndex(){
        val dynamicArray = DynamicArray<Int>()

        val insertTimeFirst = measureNanoTime {
            dynamicArray.insert(0, 1)
        }
        println("insert element at index 0: $insertTimeFirst ns")
    }

    fun insertElementMiddleIndex(){
        val dynamicArray = DynamicArray<Int>()

        val insertTimeMiddle = measureNanoTime {
            dynamicArray.insert(500000, 500000)
        }
        println("insert element at index 500000: $insertTimeMiddle ns")
    }

    fun insertElementLastIndex(){
        val dynamicArray = DynamicArray<Int>()

        val insertTimeLast = measureNanoTime {
            dynamicArray.insert(999999, 999999)
        }
        println("insert element at index 999999: $insertTimeLast ns")
    }

    fun deleteElementFirstIndex(){
        val dynamicArray = DynamicArray<Int>()

        val deleteTimeFirst = measureNanoTime {
            dynamicArray.remove(0)
        }
        println("Delete element at index 0: $deleteTimeFirst ns")
    }

    fun deleteElementLastIndex(){
        val dynamicArray = DynamicArray<Int>()

        val deleteTimeLast = measureNanoTime {
            dynamicArray.add(999999)
        }
        println("Delete element at index 999999: $deleteTimeLast ns")
    }

    fun getFirstElement(){
        val dynamicArray = DynamicArray<Int>()
        val accessTimeFirst = measureNanoTime {
            dynamicArray[0]
        }
        println("Time taken to get first element $accessTimeFirst ns")
    }

    fun getMiddleElement(){
        val dynamicArray = DynamicArray<Int>()
        val accessTimeMiddle = measureNanoTime {
            dynamicArray[0]
        }
        println("Time taken to get middle element $accessTimeMiddle ns")
    }

    fun getLastElement(){
        val dynamicArray = DynamicArray<Int>()
        val accessTimeLast = measureNanoTime {
            dynamicArray[999999]
        }
        println("Time taken to get Last element $accessTimeLast ns")
    }

    fun add10Elements(){
        val dynamicArray = DynamicArray<Int>()


        val dynamicArray1 = DynamicArray<Int>()
        val add10Elements = measureNanoTime {
            repeat(10) {
                dynamicArray1.add(it)
            }
        }
        println("Time taken to add 10 elements: $add10Elements ns")
    }

    fun add100Elements(){
        val dynamicArray2 = DynamicArray<Int>()
        val add100Elements = measureNanoTime {
            repeat(100) {
                dynamicArray2.add(it)
            }
        }
        println("Time taken to add 100 elements: $add100Elements ns")
    }

    fun add1_000Elements(){
        val dynamicArray3 = DynamicArray<Int>()
        val add1_000Elements = measureNanoTime {
            repeat(1000) {
                dynamicArray3.add(it)
            }
        }
        println("Time taken to add 1000 elements: $add1_000Elements ns")
    }

    fun add10_000Elements(){
        val dynamicArray4 = DynamicArray<Int>()
        val add10_000Elements = measureNanoTime {
            repeat(10000) {
                dynamicArray4.add(it)
            }
        }
        println("Time taken to add 10000 elements: $add10_000Elements ns")
    }

    fun add100_000Elements(){
        val dynamicArray5 = DynamicArray<Int>()
        val add100_000Elements = measureNanoTime {
            repeat(100000) {
                dynamicArray5.add(it)
            }
        }
        println("Time taken to add 100000 elements: $add100_000Elements ns")
    }

    fun add1_000_000Elements(){
        val dynamicArray6 = DynamicArray<Int>()
        val add1_000_000Elements = measureNanoTime {
            repeat(1000000) {
                dynamicArray6.add(it)
            }
        }
        println("Time taken to add 1000000 elements: $add1_000_000Elements ns")
    }
}

