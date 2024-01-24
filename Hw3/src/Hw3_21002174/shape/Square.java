package Hw3_21002174.shape;

public class Square extends Rectangle {
    private double width;

    public Square(double width) {
        super(width, width);
        this.width = width;
    }

    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.width * this.width;
    }

    @Override
    protected double getPerimeter() {
        return 4 * this.width;
    }
}
