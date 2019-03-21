package day02;
// 1. 定义一个判断闰年的方法，在 main 方法中调用该方法判断输入的一个年份是否是闰年。
import java.util.Scanner;

public class E1 {
    public boolean isLeapYear(int year){
        return year % 4 == 0 || (year % 400 == 0 && year % 100 != 0);
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Input year:");
        int year = scanner.nextInt();
        E1 e1=new E1();
        System.out.println(year+" is leap year:"+e1.isLeapYear(year));
    }
}


/*
package day02;
// 1. 定义一个判断闰年的方法，在 main 方法中调用该方法判断输入的一个年份是否是闰年。
import java.util.Scanner;
 // static ：静态方法中只能引用静态成员
public class E1 {
    public static boolean isLeapYear(int year){ // static 使isLeapYear成员变成静态
        return year % 4 == 0 || (year % 400 == 0 && year % 100 != 0);
    }
    public static void main(String[] args) {  // 静态方法中只能引用静态成员
        Scanner scanner= new Scanner(System.in);
        System.out.println("Input year:");
        int year = scanner.nextInt();
        System.out.println(year+" is leap year:"+isLeapYear(year));
    }
}
*/