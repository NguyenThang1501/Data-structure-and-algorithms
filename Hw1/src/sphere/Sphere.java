package sphere;

public class Sphere {
    private double r;
    private double x;
    private double y;
    private double z;

    public Sphere(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "bán kính r=" + r +
                ", tọa độ tâm (x, y, z) = (" + x + "," + y + "," + z + ')';
    }

    public double surfaceArea() {
        return 4 * Math.PI * r * r;
    }

    public double volume() {
        return 4.0 / 3 * Math.PI * Math.pow(this.r, 3);
    }

    public double distanceTowCentre(Sphere sphere) {
        double s = 0;
        s = Math.pow(sphere.x - this.x, 2) + Math.pow(sphere.y - this.y, 2) + Math.pow(sphere.z - this.z, 2);
        return Math.sqrt(s);
    }

    public boolean checkBaoNhau(Sphere sphere) {
        double distance = distanceTowCentre(sphere);
        return (distance < Math.abs(sphere.r - this.r));
    }

    public boolean checkGiaoNhau(Sphere sphere) {
        double distance = distanceTowCentre(sphere);
        return (distance > Math.abs(sphere.r - this.r) && (distance < sphere.r + this.r));
    }

}
