package myArray;


/**
 * 给一个非负值数组,问这个数组所构成的列表，能盛多少水
 * 时间复杂度为 O(N)，额外空间复杂度为 O(1)
 *
 * arr = {3,1,2,5,2,4} 能盛下五格水
 *
 * 思路：假设现在来到i位置，0 - i-1位置最大值是10   i+1 - arr.length - 1 最大值是 20
 * 那么 第i格子最高水位是 10
 */
public class HowMuchWater {

    public static void main(String[] args) {
       int[]  arr = {1,2,1};
        int water1 = getWater1(arr);

        System.out.println(water1);

        int water2 = getWater2(arr);
        System.out.println(water2);

        int water3 = getWater3(arr);
        System.out.println(water3);

        int water4 = getWater4(arr);
        System.out.println(water4);

    }

    // 时间复杂度为 n^2 的算法
    public static int getWater1(int[] arr){

        if (arr == null || arr.length < 3){
            return 0;
        }
        int res = 0 ;

        //0  length - 1位置肯定没有水，
        for (int i=1;i<arr.length - 1;i++){

            int leftMax = 0;
            int rightMax = 0;
            // 求左侧的最大值
            for (int l = 0;l < i;l++){
                leftMax = Math.max(arr[l],leftMax);
            }
            // 求右侧的最大值
            for (int r = i+1;r < arr.length;r++){
                rightMax = Math.max(arr[r],rightMax);
            }

            //计算当前i位置的水量
            res +=  Math.max(Math.min(leftMax,rightMax) - arr[i],0);
        }

        return res;
    }

    // 时间复杂度为O(n)  空间复杂度O(n)的算法
    // 另外开两个相同大小的的数组leftMax[]  rightMax[]  分别存储i位置上的左边最大值，和右边最大值
    public static int getWater2(int[] arr){

        if (arr == null || arr.length < 3){
            return 0;
        }

        // 左边最大值数组
        int[] leftMaxs = new int[arr.length];

        //左边第一个元素,没有值了
        leftMaxs[0] = arr[0];
        for (int i =1;i<leftMaxs.length;i++){
            leftMaxs[i] = Math.max(leftMaxs[i-1],arr[i]);
        }

        // 右边最大值数组
        int[] rightMaxs = new int[arr.length];
        // 最右边一个元素没有最大值了，设置为自身
        rightMaxs[arr.length - 1] = arr[arr.length - 1];
        for (int j = rightMaxs.length - 2; j >= 0; j-- ){
            rightMaxs[j] = Math.max(rightMaxs[j+1],arr[j]);
        }


        int res = 0 ;
        //0  length - 1位置肯定没有水，
        for (int i = 1;i < arr.length - 1;i++){
            //计算当前i位置的水量
            res +=  Math.max(Math.min(leftMaxs[i - 1],rightMaxs[i + 1]) - arr[i],0);
        }
        return res;
    }

    // 时间复杂度为O(n)  空间复杂度O(1)的算法
    //  左右指针的写法
    public static int getWater3(int[] arr){

        if (arr == null || arr.length < 3) {
            return 0;
        }
        int res = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int L = 1;
        int R = arr.length - 2;
        while (L <= R) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - arr[L]);
                leftMax = Math.max(leftMax, arr[L++]);
            } else {
                res += Math.max(0, rightMax - arr[R]);
                rightMax = Math.max(rightMax, arr[R--]);
            }
        }
        return res;
    }

public static int getWater4(int[] height){
    if (height == null || height.length < 3){
        return 0;
    }

    int start = 1;
    int end = height.length - 2;
    int leftMax = height[0];
    int rightMax = height[height.length - 1];

    int res = 0;

    while(start <= end){
        if (leftMax <= rightMax){
            res += Math.max(0,leftMax - height[start]);
            leftMax = Math.max(leftMax,height[start++]);
        }else {
            res += Math.max(0,rightMax - height[end]);
            rightMax = Math.max(rightMax,height[end--]);
        }
    }
    return res;
}
}
