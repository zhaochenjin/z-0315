package day04;
// 面试题3.4 装箱问题
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
