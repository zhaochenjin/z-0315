package day02;

public class ScopeTest {
    //private int anInt;// 放到最后，只要在大括号内都可以
    private String string="hi";

    public ScopeTest(int anInt, String string) {
        this.anInt = anInt;
        this.string = string;
        getAnInt();
    }

    public static void main(String[] args) {
        ScopeTest scopeTest=new ScopeTest(1,"hi");
        scopeTest.method();
    }
    public void method(){
        String string="hello"; // 方法内的局部变量可以覆盖同名的域
        System.out.println(string);
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
        int j=0;
        // int j=1;
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        } // i作用域范围只在for内
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
        // System.out.println(i); // 无法解析i
    }
    private int anInt;
}
