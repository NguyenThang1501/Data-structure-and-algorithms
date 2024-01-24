package Hw3_21002174.shape;

public class Sphere extends Shape{
    protected double radius = 0;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 4.0 / 3 * Math.PI * Math.pow(this.radius, 3);
    }

    @Override
    protected double getArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }
}
