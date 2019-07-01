package myList;

import utils.ListNode;

/**
 * 链表删除重复元素
 */
public class DeleteDuplicate {

    public ListNode delete(ListNode head)
    {
        if(head == null || head.next == null) return  head;
        //当前节点
        ListNode current = head;
        while(current.next != null)
        {
            if (current.val == current.next.val)
            {
                current.next = current.next.next;
            }else
            {
                current = current.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();

        ListNode.print(deleteDuplicate.delete(ListNode.createTestData("[1,1,2]")));
        ListNode.print(deleteDuplicate.delete(ListNode.createTestData("[1,1,2,3,3]")));
    }
}
