package day03;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<String> strings=new Vector<>();
        // add  添加
        for (int i = 0; i <10 ; i++) {
            strings.add("hello");
        }
        strings.add("hi");

        // size 大小 个数
        System.out.println(strings.size());

        // get 取
        System.out.println(strings.get(0));

        // capacity 容量 变原来的2倍
        System.out.println(strings.capacity());

        for (int i = 0; i <strings.size() ; i++) {
            System.out.println(strings.get(i));
        }
        for(String string:strings){
            System.out.println(string);
        }
    }
}
