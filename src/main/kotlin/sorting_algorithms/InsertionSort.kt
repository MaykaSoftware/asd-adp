package sorting_algorithms

fun <T : Comparable<T>> insertionSort(array: Array<T>): Array<T> {
    for (i in 1..<array.size) {
        val key = array[i]
        var j = i - 1

        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }

        array[j + 1] = key
    }

    return array
}
