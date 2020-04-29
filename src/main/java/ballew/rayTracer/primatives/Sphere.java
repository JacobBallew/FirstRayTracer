package ballew.rayTracer.primatives;

import ballew.rayTracer.domain.Point;
import ballew.rayTracer.utils.LIBUltra;

import java.util.Random;

public class Sphere implements Primitive{

    private double radius;
    private double diameter;
    private Point position;
    private int uniqueID;
    private LIBUltra.SHAPE_TYPES shapeType;

    public Sphere(double radius, Point position) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.position = position;
        this.uniqueID = getUniqueID();
        this.shapeType = LIBUltra.SHAPE_TYPES.SPHERE;
    }

    public Sphere() {
        this.radius = 1;
        this.diameter = radius * 2;
        this.position = new Point(0, 0, 0);
        this.uniqueID = getUniqueID();
        this.shapeType = LIBUltra.SHAPE_TYPES.SPHERE;
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

    // Getters and Setters ===============================
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
