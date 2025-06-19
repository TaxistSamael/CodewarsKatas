package Kata

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

//best solution
fun splitStrings2(s: String) = s.chunked(2).map { it.padEnd(2, '_') }

fun splitStrings(s: String): List<String> {
    val string = if (s.isEmpty() || s.count().rem(2) == 0) s else s + "_"
    return string.chunked(2)
}

class SolutionTest {
    @Test
    fun basicTests() {
        assertEquals(emptyList<String>() , splitStrings(""), "Should handle empty string")
        assertEquals(listOf("ab", "cd", "ef"), splitStrings("abcdef"), "Should handle even string")
        assertEquals(listOf("ab", "cd", "ef", "g_"), splitStrings("abcdefg"), "Should handle odd string")
    }
}
