package myList;

import utils.ListNode;

/**
 * 给定一个单向链表的头节点 head，以及两个整数 from 和 to，在单向链表上把第 from 个节
 * 点到第 to 个节点这一部分进行反转。
 * 例如：
 * 1->2->3->4->5->null，from=2，to=4
 * 调整结果为：1->4->3->2->5->null
 * 再如：
 * 1->2->3->null，from=1，to=3
 * 调整结果为：3->2->1->null
 */
public class ReversePartList {

    public static void main(String[] args) {

    }

    // 延续翻转链表的思路，只不过将翻转的头节点放到了第n个节点
    public ListNode reversePartList(ListNode head,int from,int to){

        int len = 0;
       ListNode cur = head;
       ListNode fpre = null;
       ListNode tPos = null;

       while(cur != null){
           len++;
           fpre = len == from - 1 ? cur : fpre;
           tPos = len == to + 1? cur : tPos;
           cur = cur.next;
       }

       // 边界值处理
       if (from > to || from < 1 || to > len){
           return head;
       }

       cur = fpre == null ? head : fpre.next;
       ListNode node2 = cur.next;
       cur.next = tPos;
       ListNode next;

       while (node2 != tPos){
           next = node2.next;
           node2.next = cur;
           cur  = node2;
           node2 = next;
       }

       while(fpre != null){
           fpre.next = cur;
           return head;
       }

       return cur;
    }
}
