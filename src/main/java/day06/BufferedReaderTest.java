package day06;
// bufferedReader.readLine(); 一行一行读取
import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("README.md"))
        ) {
            String line=bufferedReader.readLine();
            while(line!=null){
                System.out.println(line);
                line=bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
