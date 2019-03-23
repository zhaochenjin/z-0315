package day05;
// 输出流 OutputStream  基于字节的输出流 只能输出英文字母

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
    public static void main(String[] args) {
        try(OutputStream outputStream=new FileOutputStream("output_stream.txt");// 新建output_stream.txt 在z-0305里面
            ){
            outputStream.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
