package day06;

import java.io.*;
import java.net.URL;

// 粘贴复制豆瓣里面的某个的图片
public class Douban2 {
    private static final String DOUBAN_URL = "https://book.douban.com/tag/小说?start=";
    private static int counter;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 383; i++) {
            int start = i * 20;
            System.out.println("download page: " + (i + 1));
            downloadPage(DOUBAN_URL + start);
        }
    }

    private static void download(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("data/" + (++counter) + ".jpg"))
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
