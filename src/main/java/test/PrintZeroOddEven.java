package test;

public class PrintZeroOddEven {


    public static Object o = new Object();
    public static int count = 1;

    public static boolean zeroFlag = true;
    public static boolean oddFlag = true;
    public static boolean evenFlag = true;


    public static void main(String[] args) {

        int n = 5;
        new Thread(() -> {
            zero(n);
        }).start();
        new Thread(() -> {
            odd(n);
        }).start();
        new Thread(() -> {
            even(n);
        }).start();

    }

    public static void zero(int n) {
        while (true) {
            synchronized (o) {
                if (count >= n) break;
                if (!zeroFlag) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印
                System.out.print(0);
                zeroFlag = false;
                if ((count + 1) % 2 == 1) {
                    oddFlag = true;
                } else {
                    evenFlag = true;
                }
                o.notifyAll();
            }
        }
    }

    public static void odd(int n) {
        while (true) {
            synchronized (o) {
                if (count > n) break;
                if (zeroFlag) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印
                System.out.print(count);
                oddFlag = false;
                evenFlag = false;
                zeroFlag = true;
                count++;

                o.notifyAll();
            }
        }
    }

    public static void even(int n) {
        while (true) {
            synchronized (o) {
                if (count > n) break;
                if (zeroFlag) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印
                System.out.print(count);
                oddFlag = false;
                evenFlag = false;
                zeroFlag = true;
                count++;
                o.notifyAll();
            }
        }
    }

}
