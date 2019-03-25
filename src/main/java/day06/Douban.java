package day06;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Douban {
    private static final String DOUBAN_URL="https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4";

    public static void main(String[] args) throws IOException {
    URL url=new URL(DOUBAN_URL);

    // 字节流转换为字符流
        InputStream inputStream=url.openStream();

        Reader reader=new InputStreamReader(inputStream);
    try(BufferedReader bufferedReader=new BufferedReader(reader) ){

/*    String line=bufferedReader.readLine();
            while(line!=null){
            System.out.println(line);
            line=bufferedReader.readLine();
  */
            String line;
        while((line=bufferedReader.readLine())!=null){
        System.out.println(line);
        }
    }
    }
}
