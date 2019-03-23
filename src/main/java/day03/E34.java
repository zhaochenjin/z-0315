package day03;
// 34. 随机生成[1， 20]数10000次，使用两种方法实现（java.lang.Math，java.util.Random），并判断两种方法的效率和分布。
// Math更快一些
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class E34 {
 public static final int COUNT = 10000;

private static Hashtable<Integer,Integer> hashtable;

private static void init(){
 hashtable=new Hashtable<>();
 for (int i = 0; i <20 ; i++) {
  hashtable.put(i+1,0);
 }
}

 private static void mathTest(){
 init();
  for (int i = 0; i < COUNT ; i++) {  // COUNT选中 右键refactor ->extract ->constant  Ctrl+Alt+C
   int r= (int)(Math.random()*20+1);
   System.out.println(r);

   hashtable.put(r,hashtable.get(r)+1);
  }
  for (Map.Entry<Integer,Integer>entry:hashtable.entrySet()) {
   System.out.println(entry.getKey()+"->"+entry.getValue());
  }
  }


 private static void randomTest(){
 init();
  for (int i = 0; i <COUNT ; i++) {
   Random random=new Random();
   int r=random.nextInt(20)+1; // Ctrl+Q 看文档
   System.out.println(r);

   hashtable.put(r,hashtable.get(r)+1);
  }
   for (Map.Entry<Integer,Integer>entry:hashtable.entrySet()) {
   System.out.println(entry.getKey()+"->"+entry.getValue());
  }
  }


 public static void main(String[] args) {
  long start =System.nanoTime();
  mathTest();
  System.out.println("----------------------------------------------------");
  randomTest();
  System.out.println(System.nanoTime()-start);
 }
 }

