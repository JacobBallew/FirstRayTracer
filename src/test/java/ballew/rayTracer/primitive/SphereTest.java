package ballew.rayTracer.primitive;

import ballew.rayTracer.dataStructures.Intersections;
import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Ray;
import ballew.rayTracer.domain.Vector;
import ballew.rayTracer.utils.LIBUltra;
import org.junit.Assert;
import org.junit.Test;


public class SphereTest {

    @Test
    public void createSphere() {
        Sphere s = new Sphere();
        System.out.println(s);
    }

    @Test
    public void shouldNotEqual() {
        Sphere s = new Sphere();
        Sphere s2 = new Sphere();
        System.out.println(s);
        System.out.println(s2);
        Assert.assertFalse(s.equals(s2));
    }

    @Test
    public void intersectTwoPoint_Sphere() {
        Ray r = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        Intersections intersections = new Intersections(r.intersect(s));

        Assert.assertEquals(4.0, intersections.get(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(6.0, intersections.get(1).tValue(), LIBUltra.EQUALITY_EPSILON);
    }

    @Test
    public void intersectTangent_Sphere() {
        // Two intersections give same points
        Ray r = new Ray(new Point(0, 1, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        Intersections intersections = new Intersections(r.intersect(s));

        Assert.assertEquals(intersections.get(1).tValue(), intersections.get(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(intersections.get(0).tValue(), intersections.get(1).tValue(), LIBUltra.EQUALITY_EPSILON);
//        System.out.println(intersections.get(0).tValue());
//        System.out.println(intersections.get(1).tValue());
    }

    @Test
    public void noIntersect_Sphere() {
        Ray r = new Ray(new Point(0, 2, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();

        Intersections intersections = new Intersections(r.intersect(s));

        Assert.assertTrue(intersections.getCount() == 0);
    }

    @Test
    public void rayIsInside_Sphere() {
        Ray r = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        Intersections intersects = new Intersections(r.intersect(s));

        Assert.assertTrue(intersects.getCount() == 2);
        Assert.assertEquals(-1.0, intersects.get(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(1.0, intersects.get(1).tValue(), LIBUltra.EQUALITY_EPSILON);
    }

    @Test
    public void sphereIsBehindRay_Sphere() {
        Ray r = new Ray(new Point(0, 0, 5), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        Intersections intersects = new Intersections(r.intersect(s));

        Assert.assertTrue(intersects.getCount() == 2);
        Assert.assertEquals(-6.0, intersects.get(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(-4.0, intersects.get(1).tValue(), LIBUltra.EQUALITY_EPSILON);
    }

    // Transformations
    @Test
    public void defaultTransformation() {
        Sphere s = new Sphere();
        Assert.assertEquals(Matrix.createIdentityMatrix(), s.getTransform());
    }

    @Test
    public void changingSphereTransformation() {
        Sphere s = new Sphere();
        Matrix translation = Matrix.translation(2, 3, 4);
        //s.setTransform(translation);
        Sphere.setTransform(s, translation);
        Assert.assertEquals(translation, s.getTransform());
    }

    @Test
    public void intersectingAScaledSphereWithRay() {
        Ray r = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        s.setTransform(Matrix.scaling(2, 2, 2));
        Intersections intersections = new Intersections(r.intersect(s));

        Assert.assertEquals(2, intersections.getCount());
        Assert.assertEquals(3, intersections.get(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(7, intersections.get(1).tValue(), LIBUltra.EQUALITY_EPSILON);
    }

    @Test
    public void intersectATranslatedSphereWithARay(){
        Ray r = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        Sphere s = new Sphere();
        s.setTransform(Matrix.translation(5,0,0));
        Intersections intersections = new Intersections(r.intersect(s));

        Assert.assertEquals(0,intersections.getCount());
    }

}