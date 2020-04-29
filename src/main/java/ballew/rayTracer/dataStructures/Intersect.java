package ballew.rayTracer.dataStructures;

import ballew.rayTracer.primatives.Primitive;
import ballew.rayTracer.utils.LIBUltra;

import java.util.Objects;

public class Intersect {

    private double time; // Time
    private Primitive primitive; // What kind of shape

    public Intersect(double time, Primitive primitive) {
        this.time = time;
        this.primitive = primitive;
    }

    // Getters and Setters =============================
    public double tValue() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Primitive getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Primitive primitive) {
        this.primitive = primitive;
    }

    public LIBUltra.SHAPE_TYPES getShapeType() {
        return getPrimitive().getShapeType();
    }

    @Override
    public String toString() {
        return "Intersect ( T Value: [" + tValue() + "] Primitive Type: [" + getShapeType() + "] ID: [" + primitive.getID() + "] )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersect intersect = (Intersect) o;
        return Double.compare(intersect.time, time) == 0 &&
                Objects.equals(primitive, intersect.primitive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, primitive);
    }
}
