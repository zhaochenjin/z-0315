package day02;
/**
 * final:可以修饰class 类   field 域   method 方法
 */
public class FinalTest {
    public static void main(String[] args) {

    }
}
 final class FinalClass{  // final 可以修饰类
    private final int anInt;// final 可以修饰域
    // private final int anInt=0; // 在声明的时候初始化
     public FinalClass(int anInt) {
         this.anInt = anInt;
     } // 在构造方法中初始化

     public final void method(){  //final 可以修饰方法
    // this.anInt=1; // 初始化之后值不能在被修改，因为是final
}
}
 // class SubTest extends FinalClass{  } // final 修饰的类FinalClass不能在作为父类被继承



/*
class FinalClass {
    private final int anInt;

    public FinalClass (){
    anInt=1;
    }
    public FinalClass(int anInt) {
        this.anInt = anInt;
    }

    public final void method() { // 终态的方法
    }
}
    class SubTest extends FinalClass{
//     public void method(){  } // 终态 的方法不能在子类中被重写
        }
*/