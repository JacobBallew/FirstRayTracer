package ballew.rayTracer.domain;

import ballew.rayTracer.primatives.Sphere;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RayTest {

    @Test
    public void position() {
        Point origin = new Point(1, 2, 3);
        Vector direction = new Vector(4, 5, 6);
        Ray ray = new Ray(origin, direction);

        Assert.assertEquals(origin, ray.getOrigin());
        Assert.assertEquals(direction, ray.getDirection());
    }

    @Test
    public void testPosition() {
        Ray ray = new Ray(new Point(2, 3, 4), new Vector(1, 0, 0));

        Assert.assertEquals(new Point(2,3,4), ray.position(0));
        Assert.assertEquals(new Point(3,3,4), ray.position(1));
        Assert.assertEquals(new Point(1,3,4), ray.position(-1));
        Assert.assertEquals(new Point(4.5,3,4), ray.position(2.5));
    }

    @Test
    public void intersectTwoPoint_Sphere() {
        Ray r = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        List intersections = r.intersect(s);
        Assert.assertEquals(4.0, intersections.get(0));
        Assert.assertEquals(6.0, intersections.get(1));
    }

    @Test
    public void intersectTangent_Sphere() {
        // Two intersections of same points
        Ray r = new Ray(new Point(0, 1, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        List intersections = r.intersect(s);
        Assert.assertEquals(intersections.get(1), intersections.get(0));
        Assert.assertEquals(intersections.get(0), intersections.get(1));
    }

    @Test
    public void noIntersect_Sphere() {
        Ray r = new Ray(new Point(0, 2, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        List intersections = r.intersect(s);
        Assert.assertTrue(intersections.size() == 0);
    }

    @Test
    public void rayIsInside_Sphere() {
        Ray r = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        List intersects = Ray.intersect(r, s);

        Assert.assertTrue(intersects.size() == 2);
        Assert.assertEquals(-1.0, intersects.get(0));
        Assert.assertEquals(1.0, intersects.get(1));
    }

    @Test
    public void sphereIsBehindRay_Sphere(){
        Ray r = new Ray(new Point(0, 0, 5), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        List intersects = Ray.intersect(r, s);

        Assert.assertTrue(intersects.size() == 2);
        Assert.assertEquals(-6.0, intersects.get(0));
        Assert.assertEquals(-4.0, intersects.get(1));
    }
}