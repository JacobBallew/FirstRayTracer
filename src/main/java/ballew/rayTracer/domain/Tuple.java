package ballew.rayTracer.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tuple {

    private double x;
    private double y;
    private double z;
    private double w;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public boolean isPoint() {
        return (w == 1);
    }

    public boolean isVector() {
        return (w == 0);
    }

    // Static Methods
    public static List<Double> toList(Tuple t) {
        return Arrays.asList(t.getX(), t.getY(), t.getZ(), t.getW());
    }

    public static Tuple fromList(List<Double> lst) {
        return new Tuple(lst.get(0), lst.get(1), lst.get(2), lst.get(3));
    }

    public static Tuple add(Tuple a1, Tuple a2) {
        double w = a1.getW() + a2.getW();
        if (w > 1) {
            System.out.println("Error: Invalid Tuple type W=" + w);
            return null;
        } else {
            return new Tuple((a1.getX() + a2.getX()), (a1.getY() + a2.getY()), (a1.getZ() + a2.getZ()), w);
        }
    }

    public static Tuple add(Tuple a1, Tuple a2, Tuple a3) {
        double w = a1.getW() + a2.getW() + a3.getW();
        if (w > 1) {
            System.out.println("Error: Invalid Tuple type W=" + w);
            return null;
        } else {
            return new Tuple((a1.getX() + a2.getX()) + a3.getX(), (a1.getY() + a2.getY()) + a3.getY(), (a1.getZ() + a2.getZ() + a3.getZ()), w);
        }
    }

    public static Tuple subtract(Tuple a1, Tuple a2) {
        double w = a1.getW() - a2.getW();
        return new Tuple(a1.getX() - a2.getX(), a1.getY() - a2.getY(), a1.getZ() - a2.getZ(), w);
    }

    public static Point toPoint(Tuple t) {
        return new Point(t.getX(), t.getY(), t.getZ());
    }

    public static Vector toVector(Tuple t) {
        return new Vector(t.getX(), t.getY(), t.getZ());
    }

    public static Tuple negate(Tuple t) {
        return new Tuple(t.getX() * -1, t.getY() * -1, t.getZ() * -1, t.getW() * -1);
    }

    public static Tuple multiply(Tuple t, double factor) {
        return new Tuple(t.getX() * factor, t.getY() * factor, t.getZ() * factor, t.getW() * factor);
    }

    public static Tuple hadamardProduct(Tuple a1, Tuple a2) {
        return new Tuple((a1.getX() * a2.getX()), (a1.getY() * a2.getY()), (a1.getZ() * a2.getZ()), (a1.getW() * a2.getW()));
    }

    public static Tuple divide(Tuple t, double divisor) {
        return new Tuple(t.getX() / divisor, t.getY() / divisor, t.getZ() / divisor, t.getW() / divisor);
    }

    public static double sumAxies(Tuple v) {
        return (v.getX() + v.getY() + v.getZ());
    }

    @Override
    public String toString() {
        return "Tuple ( X = [" + x + "]  Y = [" + y + "]  Z = [" + z + "]  W = [" + w + "] )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Objects.equals(x, tuple.x) &&
                Objects.equals(y, tuple.y) &&
                Objects.equals(z, tuple.z) &&
                Objects.equals(w, tuple.w);
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
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

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }
}
