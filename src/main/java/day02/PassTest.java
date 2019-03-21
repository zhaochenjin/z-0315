package day02;
// 参数传递方式
public class PassTest {

    private static void change(int i){ // 基本数据类型
        System.out.println(i); //2：0
        i++;
        System.out.println(i); //3：1
    }
   public static void main(String[] args) {
       int i=0;
        System.out.println(i); //1：0
        change(i);
        System.out.println(i); //4：0
    }
}

 class Paramerte{
    int anInt;

    private static void change(Paramerte paramerte){ // 引用数据类型
        System.out.println(paramerte.anInt); //2：0
        paramerte.anInt++;
        System.out.println(paramerte.anInt); //3：1
    }

    public static void main(String[] args) {
        Paramerte paramerte=new Paramerte();
        System.out.println(paramerte.anInt);// 1：0
        change(paramerte);
        System.out.println(paramerte.anInt); // 4：1
    }
}