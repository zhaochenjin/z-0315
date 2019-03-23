package day03;
// List 有序可重复
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListTest {
    public static void main(String[] args) {
        // Ctrl+Alt+shift+U 集合框架 快捷键
        ArrayList<String>strings=new ArrayList<>();
        strings.add("hello");
        strings.add("hi");
        System.out.println(strings.size());
        System.out.println(strings.get(0));
        for (String string : strings) {
            System.out.println(string);
        }
        // 如何获取ArrayList的当前容量
        // System.out.println(strings.capacity());// ArrayList不能直接用capacity获取容量值
        //Vector可以直接用capacity获取容量值
         Vector<Integer>integers=new Vector<>();
            System.out.println(integers.capacity());

    }
}
