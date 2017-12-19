package customlint

import java.nio.file.Files
import java.io.File
import java.io.IOException


object Utils {
    @Throws(IOException::class)
    fun readResource(resourceName: String, clazz: Class<*>): String {
        val classLoader = clazz.classLoader
        val f = File(classLoader.getResource(resourceName)!!.file)

        return Files.readAllLines(f.toPath()).joinToString("\n")
    }
}