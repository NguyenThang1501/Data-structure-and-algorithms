package Hw3_21002174.shape;

public class Test {
    public static Shape[] createArray(int n) {
        Shape[] shapeArray = new Shape[n];
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                shapeArray[i] = new Circle(i + 1);
            } else if (i % 3 == 1) {
                shapeArray[i] = new Sphere(i * 2);
            } else {
                shapeArray[i] = new Rectangle(i * 2, i * 3);
            }
        }
        return shapeArray;
    }

    public static void printShape(Shape[] shapeArray) {
        for (int i = 0; i < shapeArray.length; i++) {
            if (shapeArray[i] instanceof Sphere) {
                System.out.println("Sphere, Are = " + shapeArray[i].getArea() + ", Volume = " + shapeArray[i].getVolume());
                ;
            } else if (shapeArray[i] instanceof Circle) {
                System.out.println("Circle, Area = " + shapeArray[i].getArea() + ", Perimeter = " + shapeArray[i].getPerimeter());
            } else {
                System.out.println("Rectangle, Area = " + shapeArray[i].getArea() + ", Perimeter = " + shapeArray[i].getPerimeter());
            }
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = createArray(7);
        printShape(shapes);
    }
}
