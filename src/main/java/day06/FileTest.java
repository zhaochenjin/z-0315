package day06;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

// File 文件 或 目录
public class FileTest {
    public static void main(String[] args) {
 /*       File f1 =new File("README.md");
        System.out.println(f1.isFile()); // 查看它是否是文件 是文件返回true,不是返回false
        File f2 =new File("src");
        System.out.println(f2.isFile()); // 查看它是否是文件 是文件返回true,不是返回false
        System.out.println(f2.isDirectory()); // 查看它是不是目录
        System.out.println(f1.canRead()); // 是否可读
        System.out.println(f1.canWrite()); // 是否可写
        System.out.println(f1.delete()); // 成功删掉返回值为true
        System.out.println(f1.getAbsoluteFile()); // 查看绝对路径
        System.out.println(f1.getName()); //名字本身
        System.out.println(f1.getParent()); // 上一级目录名称
        System.out.println(f1.getTotalSpace()/1024/1024/1024); //
        System.out.println(f1.getUsableSpace()/1024/1024/1024); //
        System.out.println(f1.isHidden()); // 判断是否隐藏
        System.out.println(new Date(f1.lastModified())); // 上一次修改时间
        System.out.println(f1.length()); // 文件的长度
        System.out.println(Arrays.toString(f2.list())); // 所有的元素全部展示

        File f3=new File("test1/test2/test3");
        f3.mkdir();
        f3.mkdirs(); // 建立层级目录 成功建立返回值为true
        f1.renameTo(new File("new_writer.txt"));// 改名字
*/
        File c=new File("c:/");
        System.out.println(Arrays.toString(c.list())); // 显示C盘下的目录
    }
}
