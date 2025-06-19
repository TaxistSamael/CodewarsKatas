package Kata

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

fun solution(s: String): List<String> {
    val string = if (s.isEmpty() || s.count().rem(2) == 0) s else s + "_"
    return string.chunked(2)
}

class SolutionTest {
    @Test
    fun basicTests() {
        assertEquals(emptyList<String>() , solution(""), "Should handle empty string")
        assertEquals(listOf("ab", "cd", "ef"), solution("abcdef"), "Should handle even string")
        assertEquals(listOf("ab", "cd", "ef", "g_"), solution("abcdefg"), "Should handle odd string")
    }
}
