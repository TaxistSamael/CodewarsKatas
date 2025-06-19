package Kata

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

fun duplicateCount(text: String): Int {
    val duplicateCount = HashMap<Char, Int>()
    text.forEach { char ->
        if (text.count { char == it } > 1) {
            val existingCount = duplicateCount[char] ?: 0
            duplicateCount[char] = existingCount + 1
        }
    }
    return duplicateCount.size
}

class CountingDuplicatesTest {

    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCount("abcde"))
    }

    @Test
    fun `abcdea returns one`() {
        assertEquals(1, duplicateCount("abcdea"))
    }
}