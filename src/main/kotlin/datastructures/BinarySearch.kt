package datastructures

class BinaryNode<T : Comparable<T>>(var data: T) {
    var leftNode: BinaryNode<T>? = null
    var rightNode: BinaryNode<T>? = null
}

class BinarySearch<T : Comparable<T>> {
    var root: BinaryNode<T>? = null

    fun add(value: T): Boolean {
        var previous: BinaryNode<T>? = null
        var current: BinaryNode<T>? = root

        while (current != null) {
            previous = current
            current = if (value < current.data)
                current.leftNode
            else if (value > current.data)
                current.rightNode
            else {
                return false
            }
        }

        val newNode = BinaryNode(value)

        if (root == null)
            root = newNode
        else {
            if (value < previous!!.data)
                previous.leftNode = newNode
            else
                previous.rightNode = newNode
        }

        return true
    }

    fun contains(value: T): Boolean {
        return find(value) != null
    }

    fun find(value: T): BinaryNode<T>? {
        return find(value, root)
    }

    private fun find(value: T, parent: BinaryNode<T>?): BinaryNode<T>? {
        if (parent != null) {
            if (value == parent.data) return parent
            return if (value < parent.data)
                find(value, parent.leftNode)
            else
                find(value, parent.rightNode)
        }

        return null
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(parent: BinaryNode<T>?, key: T): BinaryNode<T>? {
        if (parent == null) return parent

        if (key < parent.data) parent.leftNode = remove(parent.leftNode, key)
        else if (key > parent.data) parent.rightNode = remove(parent.rightNode, key)

        else {
            if (parent.leftNode == null)
                return parent.rightNode
            else if (parent.rightNode == null)
                return parent.leftNode

            parent.data = findMinValue(parent.rightNode!!)

            parent.rightNode = remove(parent.rightNode, parent.data)
        }

        return parent
    }

    private fun findMinValue(node: BinaryNode<T>): T {
        var minv = node.data

        var currentNode = node
        while (currentNode.leftNode != null) {
            minv = currentNode.leftNode!!.data
            currentNode = currentNode.leftNode!!
        }

        return minv
    }

    fun getTreeDepth(): Int {
        return getTreeDepth(root)
    }

    private fun getTreeDepth(parent: BinaryNode<T>?): Int {
        return parent?.let { 1 + maxOf(getTreeDepth(it.leftNode), getTreeDepth(it.rightNode)) } ?: 0
    }

    fun traversePreOrder(parent: BinaryNode<T>?) {
        if (parent != null) {
            print("${parent.data} ")
            traversePreOrder(parent.leftNode)
            traversePreOrder(parent.rightNode)
        }
    }

    fun traverseInOrder(parent: BinaryNode<T>?) {
        if (parent != null) {
            traverseInOrder(parent.leftNode)
            print("${parent.data} ")
            traverseInOrder(parent.rightNode)
        }
    }

    fun traversePostOrder(parent: BinaryNode<T>?) {
        if (parent != null) {
            traversePostOrder(parent.leftNode)
            traversePostOrder(parent.rightNode)
            print("${parent.data} ")
        }
    }
}