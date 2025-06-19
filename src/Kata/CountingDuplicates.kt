package Kata

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

fun duplicateCount(text: String): Int {
    val duplicateCount = HashMap<Char, Int>()
    text.lowercase().forEach { char ->
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

    @Test
    fun `indivisibility returns one`() {
        assertEquals(1, duplicateCount("indivisibility"))
    }

    @Test
    fun `really long string containing duplicates returns three`() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
        assertEquals(3, duplicateCount(text))
    }
}