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
    }
}
