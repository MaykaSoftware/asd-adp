package datastructures

class AVLTree {
    data class AVLNode(var value: Int, var height: Int = 1, var left: AVLNode? = null, var right: AVLNode? = null)

    private var root: AVLNode? = null

    private fun height(node: AVLNode?): Int {
        return node?.height ?: 0
    }

    private fun getBalanceFactor(node: AVLNode?): Int {
        return height(node?.left) - height(node?.right)
    }

    private fun updateHeight(node: AVLNode?) {
        node?.height = 1 + maxOf(height(node?.left), height(node?.right))
    }

    private fun rightRotate(y: AVLNode?): AVLNode? {
        val x = y?.left
        val r = x?.right

        x?.right = y
        y?.left = r

        updateHeight(y)
        updateHeight(x)

        return x
    }

    private fun leftRotate(x: AVLNode?): AVLNode? {
        val y = x?.right
        val r = y?.left

        y?.left = x
        x?.right = r

        updateHeight(x)
        updateHeight(y)

        return y
    }

    private fun balance(node: AVLNode?): AVLNode? {
        if (node == null) {
            return null
        }

        updateHeight(node)

        val balance = getBalanceFactor(node)
        if (balance > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node)
        }

        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left)
            return rightRotate(node)
        }

        if (balance < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node)
        }

        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right)
            return leftRotate(node)
        }

        return node
    }

    fun find(value: Int): AVLNode? {
        return find(root, value)
    }

    private fun find(node: AVLNode?, value: Int): AVLNode? {
        if (node == null || node.value == value) {
            return node
        }

        return if (value < node.value) {
            find(node.left, value)
        } else {
            find(node.right, value)
        }
    }

    fun findMin(): AVLNode? {
        return findMin(root)
    }

    private fun findMin(node: AVLNode?): AVLNode? {
        return node?.left?.let { findMin(it) } ?: node
    }

    fun findMax(): AVLNode? {
        return findMax(root)
    }

    private fun findMax(node: AVLNode?): AVLNode? {
        return node?.right?.let { findMax(it) } ?: node
    }

    fun insert(value: Int) {
        root = insert(root, value)
    }

    private fun insert(node: AVLNode?, value: Int): AVLNode? {
        if (node == null) {
            return AVLNode(value)
        }

        if (value < node.value) {
            node.left = insert(node.left, value)
        } else if (value > node.value) {
            node.right = insert(node.right, value)
        } else {
            return node
        }

        updateHeight(node)

        return balance(node)
    }

    fun remove(value: Int) {
        root = remove(root, value)
    }

    private fun remove(node: AVLNode?, value: Int): AVLNode? {
        if (node == null) {
            return null
        }

        if (value < node.value) {
            node.left = remove(node.left, value)
        } else if (value > node.value) {
            node.right = remove(node.right, value)
        } else {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            }

            node.value = findMin(node.right)?.value ?: 0

            node.right = remove(node.right, node.value)
        }

        updateHeight(node)

        return balance(node)
    }
}