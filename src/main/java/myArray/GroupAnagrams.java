package myArray;

import java.util.*;


//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串 排序
// 👍 771 👎 0

/**
 * @author caoxiaofeng
 * @date 2021-06-26 23:17
 */
public class GroupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println();

        for (List<String> strList : lists ){

            System.out.println("[");
            for (String str : strList){
                System.out.print(str +" ");
            }
            System.out.println("]");

            System.out.println();
        }


    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        Map<String,List<String>>  strMap = new HashMap<>();

        for (String str : strs){

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String s = String.valueOf(chars);

            if (strMap.containsKey(s)){
                List<String> strList = strMap.get(s);
                strList.add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                strMap.put(s,list);
            }
        }

        for (String key : strMap.keySet()){
            res.add(strMap.get(key));
        }

        return res;
    }
}
