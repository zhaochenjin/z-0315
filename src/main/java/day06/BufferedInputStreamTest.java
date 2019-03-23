package day06;

import java.io.*;
import java.util.function.IntPredicate;

public class BufferedInputStreamTest {

    // 不用buffer 粘贴复制一张照片
   public static void noBuffered(){
        try(InputStream inputStream=new FileInputStream("1.jpg");
        OutputStream outputStream=new FileOutputStream("new.jpg");
        ){
            int i=inputStream.read();
            while(i!=-1){
                outputStream.write(i);
                i=inputStream.read();
            }
            //System.out.println(bufferedInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 用buffer复制粘贴一张照片 buffer效率比较高
    private static void buffered(){
       try(
               BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("1.jpg"));
               BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("buffer.jpg"))
               ) {
           int i=bufferedInputStream.read();
           while(i!=-1){
               bufferedOutputStream.write(i);
               i=bufferedInputStream.read();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        buffered();
       // noBuffered();
        System.out.println(System.currentTimeMillis()-start);
    }
}
