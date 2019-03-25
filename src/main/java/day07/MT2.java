package day07;
// 多实现
public  class MT2 implements Runnable { // implements 实现
    public static void main(String[] args) throws InterruptedException {
        MT2 mt2=new MT2();
        Thread thread=new Thread(mt2);
        thread.start();
        // Thread.sleep(1); // 当前线程睡眠一秒钟.所以主线程先执行
        System.out.println("test,,,");
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
    }
}
