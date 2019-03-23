package day03;
// 哈希表 无序 键值对
import java.util.Hashtable;
import java.util.Map;

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable=new Hashtable<>(); // 键值对

        //put 添加
        hashtable.put(1,"hello");
        hashtable.put(2,"hi");
        // hashtable.put(2,"hello"); // 不能存在相同的键。等同于把2键更新成hello

        //size 尺寸 个数
        System.out.println(hashtable.size());

        // get 取
        System.out.println(hashtable.get(1));

        for(Integer integer:hashtable.keySet()){
            System.out.println(integer+"->"+hashtable.get(integer));
        }
        for(String value:hashtable.values()){
            System.out.println(value);
        }
        for (Map.Entry<Integer,String>entry:hashtable.entrySet()) {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        // 判断是否存在键 foolean格式
        System.out.println(hashtable.containsKey(1));
    }
}
