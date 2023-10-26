package java_coding_interview_book.ch06

class P04 {

    fun solution(paragraph: String, banned: Array<String>): String {

        val strArr = paragraph.replace("\\W+".toRegex(), " ").lowercase().trim().split(" ")
        val map: MutableMap<String, Int> = mutableMapOf()

        for (word in strArr) {
            if (banned.contains(word)) continue
            map[word] = map.getOrDefault(word, 0) + 1
        }

        return map.maxByOrNull { it.value }!!.key
    }
}