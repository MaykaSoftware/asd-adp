package util

import java.io.File

fun readResourceFile(fileName: String): String {
    // Use the class loader to load the file from the resources directory
    val classLoader = object {}.javaClass.classLoader
    val file = File(classLoader.getResource(fileName).file)

    return file.readText()
}