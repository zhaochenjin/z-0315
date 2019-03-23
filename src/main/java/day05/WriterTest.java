package day05;
// 输出流 Writer 基于字符的输出流
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterTest {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("writer.txt")) {
            writer.write("hello，中文！");
         //   writer.flush(); // 把内存中的数据保存到硬盘里(不用写）
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}