package com.jniu.leetcode

import kotlin.math.max


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @ClassName Session3
 * @User Josse
 * @CreateTime 2020/7/31
 */

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        /*
        滑动窗口
        从第一个元素开始遍历，记录两个指针（左边界和右边界）
        使用 set 来做除重
        最后记录最大的两个指针差就是最大无重复字符子串的长度
         */
        val charSet = mutableSetOf<Char>()
        val length = s.length

        var rk = -1
        var ans = 0

        for (i in 0..length) {
            if (i != 0) {
                charSet.remove(s[i - 1])
            }
            while (rk + 1 < length && !charSet.contains(s[rk + 1])) {
                charSet.add(s[rk + 1])
                rk++
            }
            ans = max(ans, rk - i + 1)
        }
        return ans
    }
}

fun main() {
    print(Solution3().lengthOfLongestSubstring("abcabcbb"))
}