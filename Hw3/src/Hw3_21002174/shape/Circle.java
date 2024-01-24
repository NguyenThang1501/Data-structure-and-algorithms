package Hw3_21002174.shape;

public class Circle extends Shape {
    private double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    protected double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }
}
