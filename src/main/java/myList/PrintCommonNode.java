package myList;

import utils.ListNode;

/**
 * 打印两个有序链表的公共部分
 *
 */
public class PrintCommonNode {
    public static void main(String[] args) {
        // 构造数据测试
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);


        ListNode node5 = new ListNode(5);


        // 链表1
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 链表2
        node5.next = node2;

       printCommonNode(node1,node5);

    }

    // 打印两个有序链表的公共部分
    public static void printCommonNode(ListNode head1,ListNode head2){

        System.out.println("开始打印两个链表的公共部分");
        while(head1 != null  && head2 != null){
            if (head1.val < head2.val){
                head1 = head1.next;
            }else if (head2.val < head1.val){
                head2 = head2.next;
            }else {
                System.out.print(head1.val + "  ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
