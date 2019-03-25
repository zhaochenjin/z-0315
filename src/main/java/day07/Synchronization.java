package day07;

public class Synchronization { // 同步
    public static void main(String[] args) {
        Food water = new Food("water");
        Food fish = new Food("fish");
        Food Bone = new Food("bone");
        Cat cat = new Cat("Kitty", fish);
        Dog dog = new Dog("Tiger", Bone);
        cat.start();
        dog.start();
    }
}

        class Food {
        private String name;

        public Food(String name) {
            this.name = name;
        }


        synchronized void eat1() { // synchronized修饰方法。对象同，猫先，5秒后狗再。对象不同，猫狗同时吃。把synchronized去掉的话，不管对象同不同，猫和狗同时运行。
            System.out.println(Thread.currentThread().getName() + "is eating." + name + ":start...");
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is eating" + name + ":end...");
        }

        void eat2() {
            // ...
            synchronized (this) { // 修饰语句块。对象同，猫先，3秒后狗再。对象不同，猫狗同时吃。
                System.out.println(Thread.currentThread().getName() + "is eating."+name+":start...");
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "is eating" + name + ":end...");
            }
        }

        synchronized static void eat3() { // 修饰方法。对象同，不同都一样。都是猫先吃，6秒后狗再吃。
            System.out.println(Thread.currentThread().getName() + "is eating."+":start...");
            try {
                Thread.sleep(1000 * 6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is eating"  +":end...");
        }
    }

    class Cat extends Thread {
        private Food food;

        Cat(String name, Food food) {
            //super.test();调用父类的成员方法
            super(name); // super调用父类的构造方法
            this.food = food;
        }
        @Override
        public void run() {
          food.eat1();
          //  food.eat2();
              //food.eat3();
        }
    }


    class Dog extends Thread {
        private Food food;

        public Dog(String name, Food food) {
            super(name);
            this.food = food;
        }
        @Override
        public void run() {
          food.eat1();
           //food.eat2();
           // food.eat3();
        }
    }



