package test;

public class test {

    public static int climbStairs(int n) {

        if (n == 1 || n == 2){
            return n;
        }
        int[] size = new int[n];
        size[0] = 1;
        size[1] = 2;

        int i = 2;
        while (i < n){
            size[i] =  size[i-1]  + size[i-2] ;
            i++;
        }
        return size[n-1];
    }

    public static int climbStairs2(int n) {

        if (n == 1 || n == 2){
            return n;
        }

        return climbStairs2( n - 1) + climbStairs2( n - 2);
    }

    public static void main(String[] args) {
        int i1 = climbStairs(5);
        System.out.println("动态规划写法："+i1);

        int i = climbStairs2(5);
        System.out.println("递归写法："+i);
    }
}
