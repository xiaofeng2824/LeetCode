package myList;

import utils.ListNode;


/**
 *
 */
public class DivisionList {

    public static void main(String[] args) {

        ListNode testData = ListNode.createTestData("[2,4,9,7,3,4,5,6]");
        ListNode.print(testData);
        ListNode.print(divisionList(testData,5));
    }

    public static ListNode divisionList(ListNode head,int x){

        if (head == null || head.next == null) return head;

        // 创建两个虚拟头节点
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        // 遍历链表
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // 合并两个链表
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
