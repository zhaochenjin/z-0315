package day02;

/**
 * abstract 抽象: 可以修饰class 和 method
 */
/*
//抽象类中可以定义抽象方法，抽象方法必须定义在抽象类中，如果类不是抽象的，不可以定义抽象方法。
public abstract class AbstractTest {  // abstract 抽象

    public abstract void method();  // 没有实现部分，也就是{}
}
*/

public class AbstractTest{
    public static void main(String[] args) {
        // Shape shape =new Shape();  // 不能实例化
            Circle circle = new Circle(); // 抽象类的子类可以实例化
            circle.method();
    }
}

abstract class Shape{
    public abstract void method(); // 抽象的方法没有实现部分，也就是{}

}
class Circle extends Shape{ // 是用来被扩展的

    @Override  // 重写，覆盖
    public void method() {
// 抽象类的子类必须实现抽象类中所有的抽象方法
    }
}


