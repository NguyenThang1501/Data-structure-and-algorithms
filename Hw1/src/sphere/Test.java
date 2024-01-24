package sphere;

public class Test {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(4,1,2,3);
        Sphere sphere2 = new Sphere(3,1,1,0);
        Sphere sphere3 = new Sphere(1,7,5,9);

        System.out.println("Hình cầu 1: " + sphere1.toString());
        System.out.println("Hình cầu 2: " + sphere2.toString());
        System.out.println("Hình cầu 3: " + sphere3.toString());

        System.out.println("Diện tích xung quanh hình cầu 1 là:");
        System.out.println(sphere1.surfaceArea());
        System.out.println("Thể tích hình cầu 1 là:");
        System.out.println(sphere1.volume());

        if (sphere1.checkBaoNhau(sphere2)) {
            System.out.println("Hình cầu 1 và hình cầu 2 bao nhau");
        }else {
            System.out.println("Hình cầu 1 và hình cầu 2 không bao nhau");
        }

        if (sphere1.checkGiaoNhau(sphere2)){
            System.out.println("Hình cầu 1 và hình cầu 2 giao nhau");
        }else {
            System.out.println("Hình cầu 1 và hình cầu 2 không giao nhau");
        }

        if (sphere1.checkGiaoNhau(sphere3)){
            System.out.println("Hình cầu 1 và hình cầu 3 giao nhau");
        }else {
            System.out.println("Hình cầu 1 và hình cầu 3 không giao nhau");
        }
    }
}
