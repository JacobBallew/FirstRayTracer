package ballew.rayTracer.primitive;

import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.utils.LIBUltra;

import java.util.Random;

public class Sphere implements Primitive{

    private double radius;
    private double diameter;
    private Point position;
    private int uniqueID;
    private Matrix transform;
    private LIBUltra.SHAPE_TYPES shapeType;

    public Sphere(double radius, Point position) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.position = position;
        this.uniqueID = getUniqueID();
        this.shapeType = LIBUltra.SHAPE_TYPES.SPHERE;
        this.transform = Matrix.createIdentityMatrix();
    }

    public Sphere(){
         this(1, new Point(0,0,0));
    }

    private int getUniqueID() {
        int min = 1;
        int max = 10000;
        // Incorporate a "sphere manager" later, to keep track of all spheres ID's
        return new Random().nextInt((max - min) - 1) + min;
    }

    public String toString() {
        return shapeType + " ( Radius: [" + radius + "]  Position: [" + position + "]  ID: [" + uniqueID + "] )";
    }

    // Static Methods
    public static void setTransform(Sphere s, Matrix transform){
        s.setTransform(transform);
    }

    // Getters and Setters ===============================
    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public LIBUltra.SHAPE_TYPES getShapeType() {
        return shapeType;
    }

    public int getID(){
        return uniqueID;
    }



}
