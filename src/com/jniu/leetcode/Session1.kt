package com.jniu.leetcode


/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @ClassName Session1
 * @User Josse
 * @CreateTime 2020/7/30
 */

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
//        for (i in 0..nums.size) {
//            val indexOf = nums.indexOf(target - nums[i])
//            if (indexOf != -1 && indexOf != i) {
//                return intArrayOf(i, indexOf)
//            }
//        }
//        return intArrayOf()
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val a = target - nums[i]
            if (map.containsKey(a)) {
                return intArrayOf(map[a]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val value = Solution1().twoSum(nums, target)
    value.forEach {
        print("$it   ")
    }
//    assert(value.contains(0) and value.contains(1))
}