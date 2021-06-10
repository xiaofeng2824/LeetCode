package myList;


import utils.DoubleNode;
import utils.ListNode;

/**
 * 单链表 或者双链表 删除倒数第K个节点
 */
public class DeleteLastKNode {


    public static void main(String[] args) {

    }

    // 单链表shanchu
 public ListNode removeLastKNode(ListNode head,int k){
        // 边界处理
     if (head == null || k < 1){
         return  head;
     }

     //遍历整个链表  将k 递减
     ListNode cur = head;
     while (cur != null){
         cur = cur.next;
         k = k--;
     }

     // 正好删除头节点  直接将指针指向下一个
     if (k == 0){
         head = head.next;
     }

     // 删除的节点在链表中
     if (k < 0){
         cur = head;
         // 将cur 移动到要删除节点的前面一个节点
         while (++k != 0){
             cur = cur.next;
             k--;
         }

         // 删除节点 将指针指向被删除的后面一个节点即可
         cur.next = cur.next.next;

     }


        return head;
 }

    // 双链表调整
    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            // 先拿到被删除节点的后面一个节点
            DoubleNode newNext = cur.next.next;
            // 当前节点指向被删除的后面一个节点
            cur.next = newNext;

            // 被删除的后面一个节点指向当前节点
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

}
