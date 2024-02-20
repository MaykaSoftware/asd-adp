package util

import java.io.File

fun readResourceFile(fileName: String): String {
    val classLoader = object {}.javaClass.classLoader
    val file = File(classLoader.getResource(fileName).file)

    return file.readText()
}