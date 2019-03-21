package day02;
// 2. 编写一个立方体类，包含这样的属性：长度、宽度、高度等信息，通过方法来计算它的体积。
public class E2 {
    static class Cube {
        private double length;
        private double width;
        private double height;

        public Cube(double length, double width, double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }// 创建构造方法

        public double getVolume() {
            return length * width * height;
        }
    }
    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println(cube.getVolume());
    }
}


