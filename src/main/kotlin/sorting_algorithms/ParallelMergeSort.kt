package sorting_algorithms

fun <T : Comparable<T>> parallelMergeSort(array: Array<T>): Array<T> {
    if (array.size <= 1) {
        return array
    }

    val middle = array.size / 2
    val left = array.copyOfRange(0, middle)
    val right = array.copyOfRange(middle, array.size)

    val leftSorted = parallelMergeSort(left)
    val rightSorted = parallelMergeSort(right)

    return merge(leftSorted, rightSorted)
}


private fun <T : Comparable<T>> merge(left: Array<T>, right: Array<T>): Array<T> {
    var i = 0
    var j = 0
    var k = 0
    val merged = arrayOfNulls<Comparable<T>>(left.size + right.size)

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            merged[k++] = left[i++]
        } else {
            merged[k++] = right[j++]
        }
    }

    while (i < left.size) {
        merged[k++] = left[i++]
    }

    while (j < right.size) {
        merged[k++] = right[j++]
    }

    @Suppress("UNCHECKED_CAST")
    return merged as Array<T>
}