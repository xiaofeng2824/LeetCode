package stack;

import java.util.Stack;

/**
 * 判断括号是否匹配
 *
 */
public class BracketMatching {

    public static boolean isValid(String s)
    {
        //使用数组来模拟栈 大小即为字符串的大小
        char[] stack = new char[s.length() - 1 ];
        int top = 0;

        //遍历字符串转化的数组
        for(char c :s.toCharArray())
        {
            //左括号 入栈
            if (c == '(' || c == '[' || c == '{')
            {
                stack[top++] = c;
                //这种方式判断比较高效
            }else if(c == ')' && stack[--top] != '(')
            {
                return false;
            }else if (c == ']' && stack[--top] != '[')
            {
                return false;
            }else if (c == '}' && stack[--top] != '{')
            {
                return false;
            }
        }

        //如果括号匹配 最后栈顶应该是回到原处
        return top == 0;
    }

    // 直接用栈实现
    public static boolean isValid2(String s) {

        Stack stack = new Stack();

        char[] chars = s.toCharArray();

        for (char a : chars){
            if (a == '(' || a == '{' || a == '['){
                stack.push(a);
            }else if (
                           stack.isEmpty()
                            ||    (a == ')'   && (char)stack.pop() != '(')
                            ||  (a == ']'  && (char)stack.pop() != '[')
                            ||  (a == '}'  && (char)stack.pop() != '{')
            ){
                return  false;
            }
        }

        return stack.isEmpty();

    }

    //测试
    public static void main(String[] args) {
//        System.out.println(isValid("{}{}[]()"));
        System.out.println(isValid("{}{}[]()(("));
        System.out.println(isValid("{{[()()]}}"));

        System.out.println();

        //System.out.println(isValid2("]"));
        System.out.println(isValid2("{}{}[]()(("));
        System.out.println(isValid2("{{[()()]}}"));
    }


}
