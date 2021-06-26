package stack;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1839 👎 0

/**
 * @author caoxiaofeng
 * @date 2021-06-23 00:29
 */
public class GenerateBracket {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);

        System.out.println(strings);

    }

    public static List<String> generateParenthesis(int n) {


        List<String> res  = new ArrayList<>();
         generate(res,"",0,0,n);

        return res;
    }

    // count1 统计 （ 的个数  count2 统计 ） 的个数
    public  static  void generate(List<String> res,String ans,int count1,int count2,int n){

        if (count1 > n || count2 > n) return;

        if (count1 == n && count2 == n)
            res.add(ans);

        if (count1 >= count2){
            String ans1 = new String(ans);
            generate(res,ans1 + "(",count1+1,count2,n);
            generate(res,ans1 + ")",count1,count2+1,n);
        }
    }
}
