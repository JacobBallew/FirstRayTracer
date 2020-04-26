package ballew.rayTracer.domain;

public class Vector extends Tuple {

    public Vector(double x, double y, double z) {
        super(x, y, z, 0);
    }

    @Override
    public String toString() {
        return "Vector ( X = [" + this.getX() + "]  Y = [" + this.getY() + "]  Z = [" + this.getZ() + "]  W = [" + this.getW() + "] )";
    }

    public static Vector toVector(Tuple t) {
        return new Vector(t.getX(), t.getY(), t.getZ());
    }

    public static double magnitude(Vector c) {
        return Math.sqrt(Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2) + Math.pow(c.getZ(), 2) + Math.pow(c.getW(), 2));
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2) + Math.pow(this.getW(), 2));
    }

    public void normalize() {
        double x = getX() / Vector.magnitude(this);
        double y = getY() / Vector.magnitude(this);
        double z = getZ() / Vector.magnitude(this);
        double w = 0;
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    public static Vector normalizeVector(Vector v) {
        double x = v.getX() / Vector.magnitude(v);
        double y = v.getY() / Vector.magnitude(v);
        double z = v.getZ() / Vector.magnitude(v);
        double w = v.getW() / Vector.magnitude(v);
        return new Vector(x, y, z);
    }

    public static double dotProduct(Vector v1, Vector v2) {
        return (v1.getX() * v2.getX()) + (v1.getY() * v2.getY()) + (v1.getZ() * v2.getZ() + (v1.getW() * v2.getW()));
    }

    public static Vector crossProduct(Vector a, Vector b) {
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return new Vector(x, y, z);

    }
}
