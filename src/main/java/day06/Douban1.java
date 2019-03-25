package day06;
// 查看豆瓣一个页面的图片
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Douban1 {
    private static final String DOUBAN_URL="https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4";

    public static void main(String[] args) throws IOException {
        URL url=new URL(DOUBAN_URL);

        // 字节流转换为字符流
        InputStream inputStream=url.openStream();

        Reader reader=new InputStreamReader(inputStream);
        try(BufferedReader bufferedReader=new BufferedReader(reader) ){

            String line;
            while((line=bufferedReader.readLine())!=null){
                if(line.contains("subject/m")){ // 寻找内容中有subject的内容
                    String src=line.substring(line.indexOf("http"),line.length()-1); // 头是啥 尾是啥
                System.out.println(src);
            }
            }
        }
    }
}
