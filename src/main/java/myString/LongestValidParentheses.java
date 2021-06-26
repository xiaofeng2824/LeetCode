package myString;

import java.util.Stack;


//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//
//
// 示例 2：
//
//
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
//
//
// 示例 3：
//
//
//输入：s = ""
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3 * 104
// s[i] 为 '(' 或 ')'
//
//
//
// Related Topics 栈 字符串 动态规划
// 👍 1350 👎 0

import java.util.Stack;

// 最长有效括号
public class LongestValidParentheses {

    public static void main(String[] args) {

        //String s = "(()";
        //String s = ")()())";
        String s = "()(()";
        int max = longestValidParentheses(s);
        int max2 = longestValidParentheses2(s);
        System.out.println("max :"+max);
        System.out.println("max2 :"+max2);

    }

    // 自己写的，case 没有全覆盖
    public static int longestValidParentheses(String s) {

        // 边界值处理
        if (s == null || s == ""){
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int tmpMax = 0;
        Stack stack = new Stack();

        // 记录上次正确括号的位置
        int index = -1;
        for (int i=0;i<chars.length;i++){

            char a = chars[i];
            if (a == '('){
                stack.push(a);
            }else if (a == ')' && !stack.isEmpty() ){
                char b  = (char)stack.pop();
                // 匹配到了括号
                if (  b == '(' ){
                    tmpMax += 2;
                }else {
                    stack.push(b);
                    stack.push(a);
                    // 临时变量 tmpMax 清零
                    tmpMax = 0;
                }
                max = tmpMax > max ? tmpMax : max;

            }else {
                tmpMax = 0;
            }
        }

        return max;
    }

    // 暂时没搞懂
    public static  int longestValidParentheses2(String s) {
        int max=0;//存放最大的长度
        int len=s.length();//字符串长度
        Stack<Integer> stack=new Stack<Integer>();//暂存字符
        stack.push(-1);//初始化栈底
        for(int i=0;i<len;i++) {//遍历字符串
            if(s.charAt(i)=='(')//字符串存在（
                stack.push(i);//下标入栈
            else {//只有右边
                stack.pop();//下标出栈
                if(stack.isEmpty()) {//出栈以后，栈为空
                    stack.push(i);//让当前下标进栈
                }else {//不为空，就计算长度差值
                    max=Math.max(max, i-stack.peek());//选出最长的长度
                }
            }
        }
        return max;
    }


}
