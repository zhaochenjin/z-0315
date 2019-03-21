package day03;

import day02.ScopeTest;

public class StringBufferTest {
    public static void main(String[] args) {

        // String ->StringBuffer
        String s = "hello";
        StringBuffer stringBuffer = new StringBuffer(s);
        System.out.println(s);

        //StringBuffer ->String
        String string = stringBuffer.toString();
        System.out.println(string);
    }
}
