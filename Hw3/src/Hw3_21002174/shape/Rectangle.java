package Hw3_21002174.shape;

public class Rectangle extends Shape {

    private double width = 0;
    private double height = 0;

    public Rectangle(double with, double height) {
        this.width = with;
        this.height = height;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.width * this.height;
    }

    @Override
    protected double getPerimeter() {
        return 2 * (this.width + this.height);
    }
}
