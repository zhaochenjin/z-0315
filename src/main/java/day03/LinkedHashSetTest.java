package day03;
// LinkedHashSet 按元素添加顺序排序
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String>strings=new LinkedHashSet();
        strings.add("hello");
        strings.add("hi");
        System.out.println(strings.size());
        for (String string : strings) {
            System.out.println(string);
        }
        }
    }
