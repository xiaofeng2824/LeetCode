package myArray;

import java.util.ArrayList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
// 👍 1422 👎 0

public class Permute {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> arr : permute) {
            System.out.println(arr.toString());
        }

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 已经遍历过了
            if (visited[i] == 1) continue;
            // 将当前位置标记为已遍历
            visited[i] = 1;
            // 临时变量 添加当前元素
            tmp.add(nums[i]);
            // 递归访问
            backtrack(res, nums, tmp, visited);
            //恢复现场，以便于下次循环使用
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
