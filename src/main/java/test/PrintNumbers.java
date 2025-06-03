package test;

class PrintNumbers {
    private static int number = 1;
    private static final Object lock = new Object();

    // 定义 odd 方法，用于打印奇数
    public static void odd(int n) {
        while (true) {
            synchronized (lock) {
                // 当数字大于 n 或者是偶数时，线程等待
                while (number > n || number % 2 == 0) {
                    if (number > n) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number > n) {
                    break;
                }
                System.out.println("奇数: " + number);
                number++;
                // 唤醒等待的偶数线程
                lock.notify();
            }
        }
    }

    // 定义 even 方法，用于打印偶数
    public static void even(int n) {
        while (true) {
            synchronized (lock) {
                // 当数字大于 n 或者是奇数时，线程等待
                while (number > n || number % 2 != 0) {
                    if (number > n) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number > n) {
                    break;
                }
                System.out.println("偶数: " + number);
                number++;
                // 唤醒等待的奇数线程
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        // 设定打印的最大数字
        int maxNum = 20;
        // 创建奇数线程，并传入参数
        Thread oddThread = new Thread(() -> odd(maxNum));
        // 创建偶数线程，并传入参数
        Thread evenThread = new Thread(() -> even(maxNum));

        // 启动奇数线程
        oddThread.start();
        // 启动偶数线程
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
}
