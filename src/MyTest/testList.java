package MyTest;

import myList.AddTwoNumber;
import myList.CycleList;
import myList.PalindromeList_05;
import org.junit.Test;
import utils.ListNode;

public class testList {
       @Test
       //测试是否是回文链表
        public void  testList01()
        {
            ListNode head = new ListNode(1);
            ListNode node1 = new ListNode(2);
            //ListNode node2 = new ListNode(2);
            //ListNode node3 = new ListNode(1);

            head.next = node1;
            //node1.next = node2;
            //node2.next = node3;

            PalindromeList_05 palindromeList = new PalindromeList_05();

            boolean palindrome01 = palindromeList.isPalindrome01(head);
            System.out.println("链表是否是回文链表："+palindrome01);
        }

     //测试链表是否有环
    @Test
    public void test01()
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        //ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(1);

        head.next = node1;
        node1.next = head;
        //node1.next = node2;
        //node2.next = node3;
        CycleList list = new CycleList();
        boolean b = list.hasCycle(head);
        System.out.println("链表中是否有环："+b);
    }

    //测试两个链表数字相加
    /*
    *            Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    *            Output: 7 -> 0 -> 8
    * */
    @Test
    public void test02()
    {
        String str1 = "[2,4,3]";
        String str2 = "[5,6,4]";

        ListNode l1 = ListNode.createTestData(str1);

        ListNode l2 = ListNode.createTestData(str2);

        ListNode.print(l1);
        ListNode.print(l2);

        ListNode node = AddTwoNumber.addTwoNumbers(l1, l2);

        ListNode t = node;

        while(t != null)
        {
            System.out.print(t.val);
            t = t.next;
        }
    }

}
