package com.jniu.leetcode


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @ClassName Session2
 * @User Josse
 * @CreateTime 2020/7/31
 */

class ListNode(var `val`: Int, var next: ListNode? = null)

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val pre = ListNode(0)
        var cur = pre
        var carry = 0

        var ll1 = l1
        var ll2 = l2
        while (ll1 != null || ll2 != null) {
            val x = ll1?.`val` ?: 0
            val y = ll2?.`val` ?: 0

            var sum = x + y + carry

            carry = sum / 10
            sum %= 10

            cur.next = ListNode(sum)

            cur = cur.next!!
            ll1 = ll1?.next
            ll2 = ll2?.next
        }

        if (carry == 1) {
            cur.next = ListNode(carry)
        }
        return pre.next
    }
}

fun main() {
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))
    var addTwoNumbers = Solution2().addTwoNumbers(l1, l2)
    while (addTwoNumbers != null) {
        println(addTwoNumbers.`val`)
        addTwoNumbers = addTwoNumbers.next
    }
}
