package ballew.rayTracer.domain;

import ballew.rayTracer.dataStructures.Intersect;
import ballew.rayTracer.primatives.Sphere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ray {

    private Point origin;
    private Vector direction;

    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public Point position(double time) {
        Vector product = Vector.toVector(Tuple.multiply(direction, time));
        return Point.toPoint(Tuple.add(origin, product));
    }

    /*
    Returns a list of Intersect objects. This tells "time" or "t value" for each hit
    TODO: Consider returning a "Intersections" object instead
     */
    public List<Intersect> intersect(Sphere s) {
        List<Double> hits = new ArrayList();
        List<Intersect> intersectList = new ArrayList<>();

        // Calculate discriminant to determine if a intersection occurs at all
        Vector sphereToRay = Vector.toVector(Tuple.subtract(origin, new Point(0, 0, 0)));

        double a = Vector.dotProduct(direction, direction);
        double b = 2 * Vector.dotProduct(direction, sphereToRay);
        double c = Vector.dotProduct(sphereToRay, sphereToRay) - 1;

        double discrim = Math.pow(b, 2) - (4 * a * c);

        // If negative, then no intersection occurred -> return
        if (discrim < 0) {
            return intersectList;
        } else {

            // Finally Calculate the intersections
            double t1 = (-b - Math.sqrt(discrim)) / (2 * a);
            double t2 = (-b + Math.sqrt(discrim)) / (2 * a);

            hits.add(t1);
            hits.add(t2);
            Collections.sort(hits);

            // Add 1st hit
            intersectList.add(new Intersect(hits.get(0), s));
            // Add 2nd hit
            intersectList.add(new Intersect(hits.get(1), s));

            return intersectList;
        }
    }


    /*-----------------
    Static methods
     */

    public static Point position(Ray r, double time) {
        return r.position(time);
    }

    public static List<Intersect> intersect(Sphere s, Ray r) {
        return r.intersect(s);
    }

    /*-----------------
    Getters and Setters
     */

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }
}
