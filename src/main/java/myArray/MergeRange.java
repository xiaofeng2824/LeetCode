package myArray;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 数组 排序
// 👍 984 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author caoxiaofeng
 * @date 2021-06-27 18:12
 */
public class MergeRange {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};


        System.out.print("[");
        for (int i=0;i<intervals.length;i++){

            System.out.print("[");
            for (int j=0;j<intervals[i].length ;j++){
                System.out.print(intervals[i][j]+",");
            }
            System.out.print("]");
        }
        System.out.print("]");


    }

    public int[][] merge(int[][] intervals) {

        // 边界值处理
        if(intervals == null || intervals.length<=1)
            return intervals;

        List<int[]> list = new ArrayList<>();
        //Arrays.sort(arr,(a,b)->a[0]-b[0]);
        // 对数组进行排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        int i=0;
        int n = intervals.length;
        while(i<n){
            // 子数组左值
            int left = intervals[i][0];
            // 子数组右值
            int right = intervals[i][1];

            // 有越界
            while(i < n-1 && right >= intervals[i+1][0]){
                // 判断下一个数组中 右值与 上一个数组中右值谁大
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }


}
