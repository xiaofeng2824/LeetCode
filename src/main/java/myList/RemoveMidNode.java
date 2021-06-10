package myList;

import utils.ListNode;

/**
 * 删除链表中间节点或者a/b处节点
 */
public class RemoveMidNode {

    public static void main(String[] args) {

    }

    // 删除中间节点  经典快慢指针的写法
    public ListNode removeMidNode(ListNode head){
        // 边界处理  没有节点  或者只有一个节点
        if (head == null || head.next == null){
            return head;
        }
        // 只有三个节点
        if (head.next.next == null){
            return head.next;
        }

        // 快慢指针 快指针走两步  慢指针走一步
        ListNode pre = head; // 慢指针
        ListNode cur = head.next.next; // 快指针
        if (pre != null && cur != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        //删除中间的节点
        pre.next = pre.next.next;

        return head;
    }

    /**
     * 进阶问题  删除 a/b 节点
     *  1 -> 2 -> 3 -> 4 -> 5
     * 0   - 1/5 删除第一个节点
     * 1/5 -  2/5 删除第二个节点
     */
    public ListNode removeABNode(ListNode head,int a,int b){
        // 边界值处理
        if (a < 1 || a > b){
            return  head;
        }
        // 统计链表有多少个节点
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        // 求出要删除的是第几个节点
        int n = (int) Math.ceil((double)(a * count) / (double)(b));

        // 转化为删除第n个节点
        if (n == 1){
            head = head.next;
        }
        //删除第n个节点
        if (n > 1){
            cur = head;
            // 找到第n个节点的前一个节点
            while (--n > 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;

        }

        return head;
    }

}
