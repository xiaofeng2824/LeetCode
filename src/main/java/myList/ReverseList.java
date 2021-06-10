package myList;

import utils.DoubleNode;
import utils.ListNode;


/**
 * 反转单双链表
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseSingleList(ListNode head){

        ListNode pre = null;
        ListNode cur = null;

        while (head != null){
            // cur 保存原来链表的头节点的下一个节点作为新的头
            cur = head.next;
            // 将原来头节点放在新链表的头节点
            head.next = pre;
            // pre 指向新链表的头节点
            pre = head;
            // head 指向原来链表的新头
            head = cur;
        }

        // 返回新头
        return pre;
    }

    // 翻转双链表
    public  DoubleNode reverseDoubleList(DoubleNode head){
      DoubleNode pre = null;
      DoubleNode next = null;

      while (head != null){
          // next 指向旧链表的头节点的下一个节点
          next = head.next;
          // 将旧链表的头节点指向新链表的头节点
          head.next = pre;
          // 原来头节点last指针必将指向原来头节点的下一个节点
          head.last = next;
          // pre 重新指向新链表的头节点
          pre = head;
          // head 继续指向旧链表的头节点
          head = next;
      }

      return pre;
    }
}
