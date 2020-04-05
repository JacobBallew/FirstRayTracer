package ballew.rayTracer.domain;

public class Point extends Tuple {

    public Point(double x, double y, double z) {
        super(x, y, z, 1d);
    }
    @Override
    public String toString() {
        return "Point ( X = [" + this.getX() + "]  Y = [" + this.getY() + "]  Z = [" + this.getZ() + "]  W = [" + this.getW() + "] )";
    }

    public static Point toPoint(Tuple t){
        return new Point(t.getX(), t.getY(), t.getZ());
    }
}
