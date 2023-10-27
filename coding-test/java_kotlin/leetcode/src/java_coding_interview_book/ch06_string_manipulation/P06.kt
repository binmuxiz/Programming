package java_coding_interview_book.ch06_string_manipulation

import kotlin.math.max

class P06 {

    var str: String = ""
    var head: Int = 0
    var maxLen: Int = 0

    // 181ms
    fun longestPalindrome(s: String): String {

        str = s
        val len = s.length
        if (len == 1)
            return s

        for (i in 0 until len - 1) {
            extendTwoPointer(i, i+1)
            extendTwoPointer(i, i+2)
        }

        return str.substring(head, head + maxLen)
    }

    private fun extendTwoPointer(i: Int, j: Int) {
        var h = i
        var t = j

        while (h >= 0 && t < str.length && str[h] == str[t]) {
            h--
            t++
        }

        val len = t - h - 1
        if (len > maxLen) {
            maxLen = len
            head = h + 1
        }
    }
}