package myList;

import utils.ListNode;

//合并两个有序链表
/*
 * 两个指针分别指向链表的头结点  遍历两个链表 插入第三个链表即可
 * */
public class MergeSortedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l1_node1 = new ListNode(2);
        ListNode l1_node2 = new ListNode(4);
        l1.next = l1_node1;
        l1_node1.next = l1_node2;

        ListNode l2 = new ListNode(1);
        ListNode l2_node1 = new ListNode(3);
        ListNode l2_node2 = new ListNode(4);
        l2.next = l2_node1;
        l2_node1.next = l2_node2;


        System.out.println("�ϲ�����֮ǰ");
        ListNode p = l1;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println();
        System.out.println("合并的链表是：");
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root = new ListNode(0);
        ListNode pointer = root;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            pointer.next = l1;
        }
        if (l2 != null) {
            pointer.next = l2;
        }
        return root.next;
    }
}


