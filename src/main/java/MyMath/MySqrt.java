package MyMath;

/**
 * 求平方根
 */
public class MySqrt {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(10));
        System.out.println(mySqrt.mySqrt(8));
        System.out.println(mySqrt.mySqrt(9));

    }
}
