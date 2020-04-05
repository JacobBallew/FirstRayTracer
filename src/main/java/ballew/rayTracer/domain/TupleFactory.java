package ballew.rayTracer.domain;

public class TupleFactory {

    public static Point point(double x, double y, double z) {
        return new Point(x, y, z);
    }

    public static Vector vector(double x, double y, double z) {
        return new Vector(x, y, z);
    }

}
