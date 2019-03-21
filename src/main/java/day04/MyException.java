package day04;
//  throw主动抛出异常
//  在自定义异常时使用
public class MyException extends ExceptionTest {
    public void m() {
        throw new ArithmeticException();
    }
}