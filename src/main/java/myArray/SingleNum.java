package myArray;


/**
 * 在其他数都出现偶数次的数组中找到出现奇数次的数
 */
public class SingleNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 4, 2, 1, 5, 6, 6};
        int res = printOddTimesNum(arr);
        System.out.println("res : " + res);
    }

    // 找出数组中出现奇数次的数
    // 异或 偶数次数字经过异或会变成0,
    public static int printOddTimesNum(int[] arr) {
        // 边界值处理
        if (arr == null || arr.length == 0) {
            return arr == null ? null : arr[0];
        }
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }

        return res;
    }

}
