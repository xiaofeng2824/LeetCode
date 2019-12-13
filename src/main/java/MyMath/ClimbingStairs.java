package MyMath;

/**
 * 题意是爬楼梯，每次你只能爬一步或者两步，问到顶层共有多少种方案
 * 方法一：递归
 * 方法二：动态规划
 */
public class ClimbingStairs {

    //f(n) = f(n - 1) + f(n - 2)
    public int climbStairs(int n)
    {
        int a = 1,b = 1;
        while(--n > 0)
        {
            b += a;
            a = b - a;
        }
        return b;
    }

    //递归
    public int climbStairs1(int n)
    {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }

    //动态规划
    public int climbStairs2(int n)
    {
        int[] arr = new int[n>2?n+1:2];
        arr[1] = 1;
        arr[2] = 2;

        //计算
        if(n > 2)
        {
            for (int i = 3; i < n+1 ; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(10));
        System.out.println(climbingStairs.climbStairs1(10));
        System.out.println(climbingStairs.climbStairs2(10));
    }
}
