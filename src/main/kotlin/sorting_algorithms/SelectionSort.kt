package sorting_algorithms


fun <T : Comparable<T>> selectionSort(array: Array<T>): Array<T> {
    for (i in array.indices) {
        var minIndex = i

        for (j in i + 1..<array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }

    return array
}