package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Pizza
import model.Sorteren
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.system.measureNanoTime

class DynamicArrayTest {
    private val dynamicArray = DynamicArray<Int>()
    private val pizzaArray = DynamicArray<Pizza>()

    val jsonString = readResourceFile("dataset_sorteren.json")
    val deserializedData = Json.decodeFromString<Sorteren>(jsonString)

    var lijst_aflopend_2 = dynamicArray.listToDynamicArray(deserializedData.lijstAflopend2)
    var lijst_gesorteerd_aflopend_3 = dynamicArray.listToDynamicArray(deserializedData.lijstGesorteerdAflopend3)
    var lijst_herhaald_1000 = dynamicArray.listToDynamicArray(deserializedData.lijstHerhaald1000)
    var lijst_oplopend_2 = dynamicArray.listToDynamicArray(deserializedData.lijstOplopend2)
    var lijst_onsorteerbaar_3 = dynamicArray.listToDynamicArray(deserializedData.lijstOnsorteerbaar3)
    var lijst_float_8001 = dynamicArray.listToDynamicArray(deserializedData.lijstFloat8001)
    var lijst_leeg_0 = dynamicArray.listToDynamicArray(deserializedData.lijstLeeg0)
    var lijst_null_1 =dynamicArray.listToDynamicArray(deserializedData.lijstNull1)
    var lijst_null_3 = dynamicArray.listToDynamicArray(deserializedData.lijstNull3)
    var lijst_oplopend_10000 = dynamicArray.listToDynamicArray(deserializedData.lijstOplopend10000)
    var lijst_willekeurig_10000 = dynamicArray.listToDynamicArray(deserializedData.lijstWillekeurig10000)
    var lijst_willekeurig_3 = dynamicArray.listToDynamicArray(deserializedData.lijstWillekeurig3)


    @BeforeEach
    fun setUp() {
        pizzaArray.add(Pizza("Margherita", "Medium"))
        pizzaArray.add(Pizza("Pepperoni", "Large"))
        pizzaArray.add(Pizza("Vegetarian", "Small"))
        pizzaArray.add(Pizza("Hawaiian", "Medium"))
    }
    @Test
    fun insertElementAtFirstIndex() {
        val insertTimeFirst = measureNanoTime {
            lijst_oplopend_10000.set(0, 1)
        }
        println("Time taken to insert element at index 0: $insertTimeFirst ns")
    }

    @Test
    fun insertElementMiddleIndex() {
        val insertTimeMiddle = measureNanoTime {
            lijst_oplopend_10000.set(lijst_oplopend_10000.size/2, 5000)
        }
        println("Time taken to insert insert element at index 500000: $insertTimeMiddle ns")
    }

    @Test
    fun insertElementLastIndex() {
        val insertTimeLast = measureNanoTime {
            lijst_oplopend_10000.add(5000)
        }
        println("Time taken to add element: $insertTimeLast ns")
    }

    @Test
    fun removeFirstIndex() {
        val deleteTimeFirst = measureNanoTime {
            lijst_oplopend_10000.remove(0)
        }
        println("Time taken to insert to delete element at index 0: $deleteTimeFirst ns")
    }

    @Test
    fun deleteElement() {
        // Define the pizza to remove
        val pizzaToRemove = Pizza("Vegetarian", "Small")

        // Measure the time taken to remove the element
        val deleteElementTime = measureNanoTime {
            pizzaArray.removeElement(pizzaToRemove)
        }

        println("Time taken to delete element: $deleteElementTime ns")

        // Assert or print the array to verify the removal

        pizzaArray.print()
    }

    @Test
    fun comparePizza(){
        // Check if a specific Pizza object is in the DynamicArray
        val pizzaToCheck = Pizza("Vegetarian", "Small")
        val containsPizza = pizzaArray.contains(pizzaToCheck)

        if (containsPizza) {
            println("$pizzaToCheck is in the DynamicArray.")
            pizzaArray.print()
        } else {
            println("$pizzaToCheck is not in the DynamicArray.")
           pizzaArray.print()
        }
    }

    @Test
    fun findPizza(){
        val pizzaToFind = Pizza("Vegetarian", "Small")
        val indexInDynamicArray = pizzaArray.find(pizzaToFind)

        if (indexInDynamicArray != -1) {
            pizzaArray.print()
            println("$pizzaToFind found in DynamicArray at index $indexInDynamicArray")
        } else {
            pizzaArray.print()
            println("$pizzaToFind not found in DynamicArray")
        }
    }

    @Test
    fun deleteLastIndex() {
        val deleteTimeLast = measureNanoTime {
            lijst_oplopend_10000.remove(lijst_oplopend_10000.size-1)
        }
        println("Time taken to insert  to delete element at index 5000: $deleteTimeLast ns")
    }

    @Test
    fun getFirstElement() {
        val accessTimeFirst = measureNanoTime {
            lijst_oplopend_10000[0]
        }
        println("Time taken to get first element $accessTimeFirst ns")
    }

    @Test
    fun getMiddleElement() {
        val accessTimeMiddle = measureNanoTime {
            lijst_oplopend_10000[lijst_oplopend_10000.size/2]
        }
        println("Time taken to get middle element $accessTimeMiddle ns")
    }

    @Test
    fun getLastElement() {
        val accessTimeLast = measureNanoTime {
            lijst_oplopend_10000[lijst_oplopend_10000.size-1]
        }
        println("Time taken to get Last element $accessTimeLast ns")
    }

    @Test
    fun add10Elements() {
        val add10Elements = measureNanoTime {
            repeat(10) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 10 elements: $add10Elements ns")
    }

    @Test
    fun add100Elements() {
        lijst_leeg_0.clearAll()
        val add100Elements = measureNanoTime {
            repeat(100) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 100 elements: $add100Elements ns")
    }

    @Test
    fun add1_000Elements() {
        lijst_leeg_0.clearAll()
        val add1000Elements = measureNanoTime {
            repeat(1000) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 1000 elements: $add1000Elements ns")
    }

    @Test
    fun add10_000Elements() {
        lijst_leeg_0.clearAll()
        val add10000Elements = measureNanoTime {
            repeat(10000) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 10000 elements: $add10000Elements ns")
    }

    @Test
    fun add100_000Elements() {
        lijst_leeg_0.clearAll()
        val add100000Elements = measureNanoTime {
            repeat(100000) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 100000 elements: $add100000Elements ns")
    }

    @Test
    fun add1_000_000Elements() {
        lijst_leeg_0.clearAll()
        val add1000000Elements = measureNanoTime {
            repeat(1000000) {
                lijst_leeg_0.add(it)
            }
        }
        println("Time taken to add 1000000 elements: $add1000000Elements ns")
    }
}