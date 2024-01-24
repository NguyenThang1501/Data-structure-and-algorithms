import java.util.Scanner;

public class ComplexNumbers {

    public static double[] inputComplex(Scanner sc) {
        double[] complexNumber = new double[2];
        System.out.println("Nhập phần thực của số phức");
        double real = sc.nextDouble();
        complexNumber[0] = real;
        System.out.println("Nhập phần ảo của số phức");
        double imaginary = sc.nextDouble();
        complexNumber[1] = imaginary;
        return complexNumber;
    }

    public static void printComplex(double[] complexNumber) {
        System.out.println(complexNumber[0] + " + " + complexNumber[1] + "i");
    }

    public static double[] addTowComplex(double[] number1, double[] number2) {
        double[] addNumber = new double[2];
        addNumber[0] = number1[0] + number2[0];
        addNumber[1] = number1[1] + number2[1];
        return addNumber;
    }

    public static double[] multiTwoComplex(double[] number1, double[] number2) {
        double[] multiNumber = new double[2];
        multiNumber[0] = number1[0] * number2[0] - number1[1] * number2[1];
        multiNumber[1] = number1[0] * number2[1] + number1[1] * number2[0];
        return multiNumber;
    }

    public static double[] addManyComplex(int k) {
        Scanner sc = new Scanner(System.in);
        double[][] numbers = new double[k][2];
        for (int i = 0; i < k; i++) {
            numbers[i] = inputComplex(sc);
        }
        double[] addNumber = numbers[0];
        for (int i = 1; i < k; i++) {
            addNumber = addTowComplex(addNumber, numbers[i]);
        }
        return addNumber;
    }

    public static double[] multiManyNumber(int k) {
        Scanner sc = new Scanner(System.in);
        double[][] numbers = new double[k][2];
        for (int i = 0; i < k; i++) {
            numbers[i] = inputComplex(sc);
        }
        double[] multiNumber = numbers[0];
        for (int i = 1; i < k; i++) {
            multiNumber = multiTwoComplex(multiNumber, numbers[i]);
        }
        return multiNumber;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] complexNumber1 = inputComplex(scan);
        System.out.print("Số phức đầu tiên là: ");
        printComplex(complexNumber1);
        double[] complexNumber2 = inputComplex(scan);
        System.out.print("Số phức thứ hai là: ");
        printComplex(complexNumber2);
        System.out.print("Tổng hai số phức vừa nhập là: ");
        printComplex(addTowComplex(complexNumber1, complexNumber2));
        System.out.print("Tích hai số phức vừa nhập là: ");
        printComplex(multiTwoComplex(complexNumber1, complexNumber2));

        System.out.println("Số số phức cần tính là: ");
        int count = scan.nextInt();
        System.out.println("Tổng các số phức vừa nhập là:");
        printComplex(addManyComplex(count));
        System.out.println("Tích các số phức vừa nhập là");
        printComplex(multiManyNumber(count));
    }
}
