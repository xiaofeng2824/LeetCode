package test;


public class PrintOddEven {


    public static Object o = new Object();
    public static int count = 1;


    public static void main(String[] args) {

        int n = 5;
       Thread oddThread =  new Thread(()->{
         odd(n);
        });

        Thread evenThread =  new Thread(()->{
            even(n);
        });

        oddThread.start();
        evenThread.start();


        try {
            // 等待奇数线程执行完毕
            oddThread.join();
            // 等待偶数线程执行完毕
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 偶数
    public static void even(int n) {

        while (true) {
            synchronized (o) {
                if (count > n) break;
             if (count % 2 == 0){
                 System.out.println(count);
                 count++;
             }
            }
        }
    }

    // 奇数
    public static void odd(int n){

        while (true) {
            synchronized (o) {
                if (count > n) break;
                if (count % 2 == 1){
                    System.out.println(count);
                    count++;
                }
            }
        }
    }
}
