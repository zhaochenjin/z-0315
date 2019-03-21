package day02;
// 练习题 三角形求面积和周长
abstract class shaps {
    public abstract double area();
    public abstract double perimeter();
}

class Rectangle extends shaps {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        System.out.println(rectangle.area());
    }
}