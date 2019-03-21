package day02;
// interface 接口
    public interface InterfaceTest {
    int ONE_TWO_THREE=123; // 接口的域都是公有 抽象 终态的，不用写
    void method();

}
    interface A {
    void a();
}
    class InterfaceTestImpl implements InterfaceTest,A{ // 一个类可以实现多个接口

    @Override
    public void method() {

    }

    @Override
    public void a() {

    }
}
    interface B extends A,InterfaceTest{ // 接口本身可以扩展extends多个父接口

}