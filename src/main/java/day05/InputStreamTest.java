package day05;
//输入流 InputStream  基于字节的输入流 不能输出汉字，因为一个汉字几个字节
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
// 输出build.gradle文件的第一个字符
public class InputStreamTest{
    public static void main(String[] args) {
        try {
            InputStream inputStream= new FileInputStream("build.gradle");
            System.out.println((char)inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

// 查看整个文件
public class InputStreamTest {
    private static final String NAME = "src/main/java/day05/InputStreamTest.java";

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(NAME);
            int i = inputStream.read();
            while (i != -1) {
                System.out.print((char) i);
                i = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
