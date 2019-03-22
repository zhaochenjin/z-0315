package day03;

import java.util.Arrays;

public class StringStringBuffer {
    public static void main(String[] args) {

/*        String alphabet="";
        for (int i = 65; i <65+26 ; i++) {
            char c=(char)i;
            System.out.println(c);
        }
*/

/*        char[]chars=new char[26];
        int x=0;
        for (int i = 65; i <65+26 ; i++) {
            chars[x]=(char)i;
            x++;
        }
        System.out.println(Arrays.toString(chars));
*/

        char[]chars=new char[26];
        int x=0;
        for (int i = 65; i <65+26 ; i++) {
            chars[x]=(char)i;
            x++;
        }
        String alphabet=new String(chars);
        System.out.println(alphabet);

/*       //String 字符串
        long start=System.currentTimeMillis();
        String string="";
        for (int i = 0; i <100000 ; i++) {
            string+=alphabet;
        }
        // string.length=26*100000
        System.out.println(string.length());
        System.out.println("total time:"+(System.currentTimeMillis()-start)/1000+" seconds.");
*/
        // StringBuffer 字符串缓冲区
        long start=System.currentTimeMillis();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i <100000 ; i++) {
            stringBuffer.append(alphabet);
        }
        System.out.println(stringBuffer.length());
        System.out.println("total time:"+(System.currentTimeMillis()-start)+" ms.");

    }
}
