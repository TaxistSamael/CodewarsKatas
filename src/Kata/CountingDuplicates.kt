package Kata

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

//best solution
fun duplicateCount2(text: String) = text.groupBy(Char::lowercase).count { it.value.count() > 1 }

fun duplicateCount(text: String): Int {
    return text.lowercase()
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .size
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
    fun `abcdeaB returns two`() {
        assertEquals(duplicateCount("abcdeaB"), 2)
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