package sorting_algorithms

fun <T : Comparable<T>> quicksort(array: Array<T>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(array, low, high)

        quicksort(array, low, partitionIndex - 1)
        quicksort(array, partitionIndex + 1, high)
    }
}

private fun <T : Comparable<T>> partition(array: Array<T>, low: Int, high: Int): Int {
    val pivot = array[high]
    var i = low - 1

    for (j in low..<high) {
        if (array[j] <= pivot) {
            i++
            swap(array, i, j)
        }
    }

    swap(array, i + 1, high)

    return i + 1
}

private fun <T : Comparable<T>> swap(array: Array<T>, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}