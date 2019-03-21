package day04;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CheckedExceptionTest {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            m();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void m() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input file path:");
        String filePath = scanner.nextLine();

        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

        // checked exception  受检异常 是难以避免的问题
        // unchecked exception  非受检异常 是程序的 bug
        /* Throwable有两个直接子类，Error类和Exception(异常)类。
        异常分为受检异常(非运行异常)checked exception 和非受检异常(运行时异常)unchecked exception。
         */
    }
}
