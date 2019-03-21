package day02;

// class = fields + methods  类=域+方法
public class Human extends Object {

    private String name;  // 私有的
    private int age;
    private double height;
    private boolean married; // 域

    public Human() {

    } // 无参构造方法

 /*   static {
        // static block  静态块
    }

    {
        // constructor block  构造器块
        int i = 0;
    }
*/
    public Human(String name, int age, double height, boolean married) {   // Alt +Insert
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    } // 有参构造方法

    public void study(int hours) {   // hours 形式参数
        System.out.println(name + " study " + hours + " houres.");
    } // 成员方法

    public void work() {

    } // 成员方法
}


