package work;

import javax.xml.crypto.NoSuchMechanismException;
import javax.xml.stream.FactoryConfigurationError;
import java.io.*;
import java.rmi.Naming;
import java.util.Arrays;
import java.util.Date;

public class T1 {
    public static void main(String[] args) throws IOException {
        // 1. 编写一个程序，在D盘根目录下创建一个以自己名称命名的文件夹，并在该文件夹下创建一个以自己名称命名的文本文件
        File f1 = new File("d:/zhaochenjin");
        f1.mkdir();

        // File f2 = new File("d:/zhaochenjin\\zhaochenjin.txt");
        // f2.mkdir();  //   创建文本文件，不对!

        // 2. 编写java程序，查看刚才所创建的文件的属性：包括是否能读、写、相对路径、绝对路径、长度,最后修改时间等
        System.out.println(f1.canRead()); // 是否可读
        System.out.println(f1.canWrite()); //是否可写
        System.out.println(f1.getPath()); // 相对路径
        System.out.println(f1.getAbsoluteFile()); // 绝对路径
        System.out.println(f1.length()); // 长度
        System.out.println(new Date(f1.lastModified())); // 最后修改时间

        //3.编写程序向文本文件中写入自己的信息，格式为：
        try (Writer writer = new FileWriter("d:/zhaochenjin/zhaochenjin.txt")) {
            writer.write("姓名：tester" +
                    "   性别：male" +
                    "   年龄：18" +
                    "   班级：201601");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.编写一个程序，将你所编写的.java文件读出显示在屏幕上
        try (Reader reader = new FileReader("d:/zhaochenjin/zhaochenjin.txt");) {
            int i = reader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = reader.read();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //5.编写程序，列出某一目录下的所有的 Java 文件
        File c = new File("c:/");
        System.out.println(Arrays.toString(c.list())); // 显示C盘下的目录
        // 如何实现Java 文件？

        // 6. 编写程序，能将C盘的某一文件复制到D盘
        try (Reader reader = new FileReader("d:/zhaochenjin/zhaochenjin.txt");
             Writer writer = new FileWriter("c:/1.txt")
        ) {
            int i = reader.read();
            while (i != -1) {
                writer.write(i);
                i = reader.read();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 7. 创建一个文件夹，分别向该文件夹下复制几个图片，文本文件和 Java 源程序
        File f2 = new File("d:/zhao"); // 新建文件夹
        try (InputStream inputOutput = new FileInputStream("d:/zhao");
             OutputStream outputStream = new FileOutputStream("new.pdf")
        ) {
            int i = inputOutput.read();
            while (i != -1) {
                outputStream.write(i);
                i = inputOutput.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  //   复制文本文件      X

    }
}