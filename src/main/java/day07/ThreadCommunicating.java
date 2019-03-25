package day07;

public class ThreadCommunicating {
    public static void main(String[] args) {
            // ctrl+N  查看原代码
            // CTRL+F12 选中整行
            final Object lock = new Object();
            Thread thread1 = new Thread(new OutputThread(1, lock));
            Thread thread2 = new Thread(new OutputThread(2, lock));
            thread1.start();
            thread2.start();
        }
    }
class OutputThread implements Runnable {
    private int num;
    private final Object lock;

    OutputThread(int num, Object lock) {
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    System.out.println(num);
                    Thread.sleep(1000);
                    lock.notify(); // 通知其他对象唤醒
                    lock.wait();// 等待
                    // lock.notify(); // 通知其他对象唤醒
                    //lock.wait();// 等待
                    // 假设他们两个互换位置，则输出一个1，堵塞。输出一个2，堵塞。再继续进行，但是堵塞了，不再输出。

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
