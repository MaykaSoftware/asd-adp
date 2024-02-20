package datastructures

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Hashing
import org.junit.jupiter.api.Test
import util.readResourceFile
import kotlin.reflect.KProperty1
import kotlin.system.measureNanoTime

class HashTableTest {
    val jsonString = readResourceFile("dataset_hashing.json")
    val deserializedData = Json.decodeFromString<Hashing>(jsonString)
    private val map = deserializedData.hashtabelsleutelswaardes.toMapOfLists()

    private inline fun <reified T> T.toMapOfLists(): Map<String, List<Int>> {
        return T::class.members
            .filterIsInstance<KProperty1<T, List<Int>>>()
            .associateBy({ it.name }, { it.call(this) })
    }

    @Test
    fun insert() {
        val hashTable = HashTable<Int>()

        map.forEach { (key, values) ->
            val timeNanos = measureNanoTime {
                values.forEach { value ->
                    hashTable.insert(key, value)
                }
            }

            println("Insertion time for dataset $key: $timeNanos ns")
        }
    }

    @Test
    fun get() {
        val hashTable = HashTable<Int>()

        map.forEach { (key, values) ->
            values.forEach { value ->
                hashTable.insert(key, value)
            }

            val timeNanos = measureNanoTime {
                values.forEach { _ ->
                    hashTable.get(key)
                }
            }

            println("Get time for dataset $key: $timeNanos ns")
        }
    }

    @Test
    fun delete() {
        val hashTable = HashTable<Int>()

        map.forEach { (key, values) ->
            values.forEach { value ->
                hashTable.insert(key, value)
            }

            val timeNanos = measureNanoTime {
                values.forEach { _ ->
                    hashTable.delete(key)
                }
            }

            println("Delete time for dataset $key: $timeNanos ns")
        }
    }

    @Test
    fun update() {
        val hashTable = HashTable<Int>()

        map.forEach { (key, values) ->
            values.forEach { value ->
                hashTable.insert(key, value)
            }

            val timeNanos = measureNanoTime {
                values.forEach { value ->
                    hashTable.update(key, value + 1)
                }
            }

            println("Update time for dataset $key: $timeNanos ns")
        }
    }
}