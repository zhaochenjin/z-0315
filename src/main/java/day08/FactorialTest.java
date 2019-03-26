package day08;
// 21. 求1+2!+3!+…+20!的和。
// 22.利用递归方法求5！
// f(1)=1;
//f(2)=2*1；
//f(n)=n*f(n-1);
public class FactorialTest {
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));

        long sum = 0L;
        for (int i = 0; i < 21; i++) {//0，1，2，3
            sum += factorial(i + 1); // 1，2，3，4
        }
        System.out.println(sum);
/*
        int sum=0;
        for (int i = 1; i <4; i++) {
            sum+=factorial(i);
        }
        System.out.println(sum);
}*/
    }
    }