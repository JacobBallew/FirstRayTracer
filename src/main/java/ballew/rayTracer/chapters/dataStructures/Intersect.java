package ballew.rayTracer.chapters.dataStructures;

import ballew.rayTracer.primatives.Primitive;

public class Intersect<T>{

    private double time; // Time
    private Primitive primitive;

    public Intersect(double time, Primitive primitive){
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

}
