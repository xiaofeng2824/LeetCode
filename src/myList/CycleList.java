package myList;

import utils.ListNode;
/*
* 给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 如果 pos 是 -1，则在该链表中没有环。

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。




进阶：

你能用 O(1)（即，常量）内存解决此问题吗？
* */

/*
* 思路：设置快慢两个指针 都从同一节点head出发
*       慢指针每次只走一步，快指针每次走两步
*       如果有环，则两个指针必然在某个节点相遇
* */
public class CycleList {
    public boolean hasCycle(ListNode head) {
        //如果该链表没有节点或者只有一个节点 则没有环
        if(head == null || head.next == null)
            return false;

        //设置一个慢指针
        ListNode slow = head;
        //设置一个快指针
        ListNode faster = head;

        while(faster.next != null && faster.next.next != null)
        {
            slow = slow.next;
            faster = faster.next.next;

            if(slow == faster)
                return true;
        }

            return false;
    }
}
