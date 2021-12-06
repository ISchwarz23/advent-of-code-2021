import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Reads lines from the given input txt file as in values.
 */
fun readInputAsInts(name: String) = readInput(name).map { it.toInt() }

/**
 * Reads one line and map to Ints.
 */
fun readOneLineInputAsInts(name: String, delimiter: String = ","): List<Int> {
    return readInput(name)[0].split(delimiter).map { it.toInt() }
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
