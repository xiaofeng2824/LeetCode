package myList;

import utils.DoubleNode;
import utils.ListNode;


/**
 * 反转单双链表
 */
public class ReverseList {
    public static void main(String[] args) {

        ListNode testData = ListNode.createTestData("[1,2,3,4,5]");
        ListNode.print(testData);

        ListNode.print(reverseList(testData));

        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.last = node4;
        node4.last = node3;
        node3.last = node2;
        node2.last = node1;

        DoubleNode doubleNode = reverseDoubleList2(node1);

        while (doubleNode != null){
            System.out.println(doubleNode.value);
            doubleNode = doubleNode.next;
        }
    }



    public static ListNode reverseList(ListNode head) {

        ListNode pre = new ListNode(0);

        while (head != null){
            ListNode temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head=temp;
        }
        return pre.next;
    }

    public static DoubleNode reverseDoubleList2(DoubleNode head) {

        DoubleNode pre = new DoubleNode();
        while (head != null){
            DoubleNode temp = head.next;
            head.next = pre.next;
            if (pre.next != null){
                head = pre.next.last;
            }
            pre.next = head;
            head.last = pre;
            head=temp;
        }
        return pre.next;
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
