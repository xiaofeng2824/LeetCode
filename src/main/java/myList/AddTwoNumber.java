package myList;

import utils.ListNode;

/*
* 题目描述：一个链表表示一个数字  低位在前  高位在后
*           求两个链表的数字相加
*           例如：
*           Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
*           Output: 7 -> 0 -> 8
*           Explanation: 342 + 465 = 807.
* */
public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2)
    {
        //链表模拟算数运算
        //node 为头结点
        ListNode node = new ListNode(0);

        // t 为迭代变量节点
        ListNode t = node;
        ListNode n1 = l1,n2 = l2;

        //sum 为两个相同位数之和
        int sum = 0;

        while(n1 != null || n2 != null)
        {
            //如果有进位 则取出进位
            sum = sum/10;
            if(n1 != null)
            {
                sum += n1.val;
                n1 = n1.next;
            }

            if(n2 != null)
            {
                sum += n2.val;
                n2 = n2.next;
            }

            //将所求之和的个数上的数值赋值给新的节点
            t.next = new ListNode(sum%10);
            t = t.next;
        }

        return node.next;
    }



}
