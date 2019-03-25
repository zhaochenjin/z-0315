package day07;

import sun.swing.StringUIClientPropertyKey;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * mutithreading?
 */
public class Douban3 extends Thread {
    private static final String DOUBAN_URL = "https://book.douban.com/tag/小说?start=";
    private static int counter;
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
       long begin = System.currentTimeMillis();
//        for (int i = 0; i < 50; i++) {
//            int start = i * 20;
//            System.out.println("download page: " + (i + 1));
//            downloadPage(DOUBAN_URL + start);
//        }
        Douban3[] threads=new Douban3[5];
        for (int i = 0; i < 5; i++) {
            Douban3 t = new Douban3();
            t.setPage(10*i);
            threads[i]=t;
            t.start();
        }
        for (Douban3 thread : threads) {
            thread.join();
        }

        System.out.println("total time"+(System.currentTimeMillis() - begin)+"ms");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " running...");
        for (int i = 0; i < 50; i++) {
           int start = i * 20;
            System.out.println("download page: " + (i + 1));
            try {
                downloadPage(DOUBAN_URL + start);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void download(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("data1/" + (++counter) + ".jpg"))
        ) {
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        }
        System.out.println(counter + " downloads.");
    }

    private static void downloadPage(String pageUrl) throws IOException {
        URL url = new URL(pageUrl);
        InputStream inputStream = url.openStream();
        // 字节流转换为字符流
        Reader reader = new InputStreamReader(inputStream);
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("subject/m")) {
                    String src = line.substring(line.indexOf("http"), line.length() - 1);
//                    System.out.println(src);
                    download(src);
                }
            }
        }
    }
}
