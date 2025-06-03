package other;

import java.util.Scanner;

/**
 * 质数因子
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        printPrimeNumber(num);
    }

    public static  void printPrimeNumber(int num){

        // 判断是否是质数
        if(isPrime(num)){
            System.out.print(num + " ");
        }

        for(int i=2;i<= Math.sqrt(num);i++){
            int a = num % i;

            if(a == 0 && isPrime(i)){
                System.out.print(i + " ");
                printPrimeNumber(num/i);
                break;
            }
        }
    }

    //  判断一个数是否是质数
    public static boolean isPrime(int n){
        if (n <= 1) return false; // 质数定义要求大于1
        if (n == 2) return true;  // 2是质数
        if (n % 2 == 0) return false; // 偶数（除2外）不是质数

        // 检查从3到平方根的所有奇数
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
