package Hw3_21002174.complex;

public class Complex {
    private float real;
    private float image;

    public Complex(float r, float i) {
        this.real = r;
        this.image = i;
    }

    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.image + c.image);
    }

    public Complex minus(Complex c) {
        return new Complex(this.real - c.real, this.image - c.image);
    }

    public Complex time(Complex c) {
        return new Complex(this.real * c.real - this.image * c.image, this.real * c.image + this.image * c.real);
    }

    public float realPart() {
        return real;
    }

    public float imagePart() {
        return image;
    }

    public String toString() {
        if (this.realPart() == 0) {
            if (this.imagePart() == 0) {
                return "0";
            } else {
                return this.image + "i";
            }
        } else {
            return this.real + " + " + this.image + "i";
        }
    }
}
