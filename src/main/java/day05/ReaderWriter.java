package day05;
// 输入输出相对程序而言
import java.io.*;

public class ReaderWriter {
    public static void main(String[] args){
        try (Reader reader = new FileReader("README.md"); // 读取README.md 里面的内容
             Writer writer = new FileWriter("new.md") // 创建new.md文件，并把README.md 里面的内容放入
        ) {
            int i = reader.read();
            while (i != -1) {
                writer.write(i);
                i = reader.read();
            }
            writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}