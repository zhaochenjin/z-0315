package day02;

import static java.lang.System.out; // 静态导入   System.out可以直接写out

// static
public class StaticTest {
        public static void main(String[] args) {
        Mankind tom=new Mankind("Tom",19);
            tom.setAge(20);
            out.println(tom.getName());
            System.out.println(tom.getAge());
            //tom.setEarth("Tom在天软种了一棵树");
            Mankind.setEarth("Tom在天软种了一棵树");  // 静态的成员隶属于类对象
            System.out.println(tom.getEarth());
            Mankind jerry=new Mankind("jerry",18);

            jerry.setName("Jerry");
            System.out.println(jerry.getName());
            System.out.println(jerry.getAge());

            System.out.println(jerry.getEarth()); // 结果同为Tom在天软种了一棵树

        }
    }

    class Mankind{
        private static final long HUMAN_AMOUNT=7000000000L; // 静态并终态的域。只能在声明时初始化。初始化后值不能变。常量，都是大写字母，单词之间用下划线分隔
        private String name;
        private int age;
        private  static String earth; // 静态域

        public Mankind(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static String getEarth() {
            return earth;
        }

        public static void setEarth(String earth) {
            Mankind.earth = earth;
        }
    }

/*    public static void main(String[] args) {
        // Math math =new Math(); // 无需创建实例，直接用
        System.out.println(Math.PI);
        System.out.println(Math.pow(2, 3));
    }
}
*/