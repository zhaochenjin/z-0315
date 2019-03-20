package day04;
// 泛型.类型参数.interface
public interface InterfaceTest<T,S,U>{
    T method(T t, S s, U u);
}
abstract class GenericClass<T> {

    abstract void method(T t);
}

class SubGenericClass<T> extends GenericClass<T> {
    @Override
    void method(T t) {

    }
}
