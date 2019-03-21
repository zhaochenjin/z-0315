package day04;
/* 面试题3.4 装箱问题
自动装箱：Java自动将原始类型值转换成对应的对象，比如将int的变量转换成Integer对象，这个过程叫做装箱。
自动拆箱就：反之将Integer对象转换成int类型值，这个过程叫做拆箱。
因为这里的装箱和拆箱是自动进行的非人为转换，所以就称作为自动装箱和拆箱。
Integer i = 11;//自动装箱，实际上执行了Integer i = Integer.valueOf(11);
int t = i;//自动拆箱，实际上执行了 int t = i.intValue();
*/
public class BoxTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Long sum =0L;
//      long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println(System.currentTimeMillis() - start);
    }
}
