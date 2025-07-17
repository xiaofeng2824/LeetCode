package dp;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(20));
        System.out.println(climbStairs2(20));
    }

    public static int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int sum = 2;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int temp = sum;
            sum = sum + pre;
            pre = temp;

        }
        return sum;
    }
}
