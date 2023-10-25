package java_coding_interview_book.ch06

class P03 {
    fun solution(logs: Array<String>): Array<String> {

        var letterLogs = mutableListOf<String>()
        var digitLogs = mutableListOf<String>()

        for (log in logs) {
            if (Character.isLetter(log[log.length-1]))
                letterLogs.add(log)
            else
                digitLogs.add(log)
        }

        letterLogs.sortWith(Comparator { s1: String, s2: String ->
            val s1Arr = s1.split(" ", limit = 2)
            val s2Arr = s2.split(" ", limit = 2)

            val compared = s1Arr[1].compareTo(s2Arr[1])
            if (compared == 0)
                s1Arr[0].compareTo(s2Arr[0])
            else
                compared
        })

        letterLogs.addAll(digitLogs)

        return letterLogs.toTypedArray()
    }
}