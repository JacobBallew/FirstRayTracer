package ballew.rayTracer.domain;

public class Color extends Tuple {

    public Color(double con) {
        super(con, con, con, 0);
    }
    public Color(double r, double g, double b) {
        super(r, g, b, 0);
    }

    public static Color toColor(Tuple t) {
        return new Color(t.getX(), t.getY(), t.getZ());
    }

    public double getRed() {
        return this.getX();
    }

    public double getGreen() {
        return this.getY();
    }

    public double getBlue() {
        return this.getZ();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Color ( R:[" + getRed() + "] G:[" + getGreen() + "] B:[" + getBlue() + "] )";
    }


}
