package java_coding_interview_book.ch06

class P01 {

    fun solution(s: String): Boolean {
        var answer = true
        var start = 0;
        var end = s.length - 1

        while (start < end) {

            when {
                // 코틀린에서 인덱스로 직접 접근해 추출한 결과는 원시자료형이 아니라 참조형이다. 하지만 경우에 따라 원시자료형을 사용한다?
                !Character.isLetterOrDigit(s[start]) -> start++
                !Character.isLetterOrDigit(s[end]) -> end--
                else -> {
                    if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                        answer = false
                        break
                    }
                    start++
                    end--
                }
            }
        }
        return answer
    }
}