package java_coding_interview_book.ch07

class P01 {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        var map = mutableMapOf<Int, Int>()

        for ((i, value) in nums.withIndex()) {
            if (map.containsKey(target - value))
                return intArrayOf(map[target - value] ?: 0, i)
            map[value] = i
        }
        return intArrayOf(0, 0)
    }
}