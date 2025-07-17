package myList;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
* */
public class PalindromeList_05 {
    ListNode temp = null;

    /*
     * 普通方式：
     * 思路：1.先将链表转化为一个arraylist
     *      2.再将arraylist 转化为数组
     *      3.用数组方式验证是不是回文链表
     * */
    public static boolean isPalindrome(ListNode head) {

        //设置一个标识
        boolean flag = true;

        //第一步：将链表转化为一个arraylist
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //第二步，将arraylist  转化为一个数组
        Object[] objects = list.toArray();

        //用数组方式验证是否是回文链表
        //使用下坐标的方式，i指向数组头部，j指向尾部
        int i = 0;
        int j = objects.length - 1;

        while (i < j) {
            if (objects[i].equals(objects[j])) {
                i++;
                j--;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    /*
     * 进阶：
     *  你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     *  优化方案：
     *  使用递归：利用操作系统的栈来解决问题
     *  递归出口：head.next 与p.next 不相等
     *  递归函数：
     * */

    public boolean isPalindrome01(ListNode head) {
        //将temp节点暂存head节点
        temp = head;

        return isPalindromeList(head);

    }

    public boolean isPalindromeList(ListNode head) {
        if (head == null)
            return true;
        boolean result = isPalindromeList(head.next) && (head.val == temp.val);
        temp = temp.next;

        return result;
    }
}
