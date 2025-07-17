package myList;

import utils.ListNode;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1355 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * @author caoxiaofeng
 * @date 2021-06-23 08:47
 */
public class MergeKLists {
    public static void main(String[] args) {
        //lists = [[1,4,5],[1,3,4],[2,6]]

        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);

        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        ListNode head3 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        head3.next = node5;


        ListNode[] arr = {head1, head2, head3};

        ListNode node = mergeKLists(arr);

        // 打印链表
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

    }


    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 分而治之
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] list, int left, int right) {

        // 单个链表直接返回
        if (left == right) return list[left];

        int mid = left + (right - left) / 2;
        // 左半边 合并成一个链表
        ListNode l1 = merge(list, left, mid);
        // 右半边 合并成一个链表
        ListNode l2 = merge(list, mid + 1, right);
        // 两个链表 合并成一个链表
        return mergeTwoList(l1, l2);
    }

    // 两个有序链表合并
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }

    }
}
