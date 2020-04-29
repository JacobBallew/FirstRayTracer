package ballew.rayTracer.dataStructures;

import ballew.rayTracer.primatives.Sphere;
import ballew.rayTracer.utils.LIBUltra;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionsTest {

    Intersections intersections = new Intersections();

    @Test
    public void multiIntersects() {
        Sphere s = new Sphere();

        Intersect i1 = new Intersect(1, s);
        Intersect i2 = new Intersect(2, s);
        intersections.add(i1, i2);

        Assert.assertEquals(2, intersections.getCount());
        Assert.assertEquals(1, intersections.getIntersect(0).tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(2, intersections.getIntersect(1).tValue(), LIBUltra.EQUALITY_EPSILON);
    }

    @Test
    public void sortingTheList() {
        // Manually created spheres since they are unique
        Sphere s1 = new Sphere();
        Sphere s2 = new Sphere();
        Sphere s3 = new Sphere();
        Sphere s4 = new Sphere();
        Sphere s5 = new Sphere();

        // Unsorted
        //System.out.println("Unsorted");
        Intersections unSorted = new Intersections();
        unSorted.add(new Intersect(9, s1));
        unSorted.add(new Intersect(0, s2));
        unSorted.add(new Intersect(2, s3));
        unSorted.add(new Intersect(1, s4));
        unSorted.add(new Intersect(4, s5));
        //unSorted.print();

        // Expected
        Intersections expected = new Intersections();
        expected.add(new Intersect(0, s2));
        expected.add(new Intersect(1, s4));
        expected.add(new Intersect(2, s3));
        expected.add(new Intersect(4, s5));
        expected.add(new Intersect(9, s1));

        // Sort
        //System.out.println("Sorted");
        unSorted.sort();

        Assert.assertEquals(expected.get(0), unSorted.get(0));
        Assert.assertEquals(expected.get(1), unSorted.get(1));
        Assert.assertEquals(expected.get(2), unSorted.get(2));
        Assert.assertEquals(expected.get(3), unSorted.get(3));
        Assert.assertEquals(expected.get(4), unSorted.get(4));
    }

    // Hit testing, return lowest non negative Intersect(t value) from Intersections obj
    @Test
    public void hitWhenAllPositive() {
        Sphere s = new Sphere();
        Intersect i1 = new Intersect(1, s);
        Intersect i2 = new Intersect(2, s);
        Intersections intersections = new Intersections(i1, i2);

        Intersect hit = intersections.hit();
        Assert.assertEquals(i1, hit);
    }

    @Test
    public void hitWhenSomeNegative() {
        Sphere s = new Sphere();
        Intersect i1 = new Intersect(-1, s);
        Intersect i2 = new Intersect(1, s);
        Intersections intersections = new Intersections(i1, i2);

        Intersect hit = intersections.hit();
        Assert.assertEquals(i2, hit);
    }

    @Test
    public void hitWhenAllNegative() {
        Sphere s = new Sphere();
        Intersect i1 = new Intersect(-2, s);
        Intersect i2 = new Intersect(-1, s);
        Intersections intersections = new Intersections(i1, i2);

        Intersect hit = Intersections.hit(intersections);
        Assert.assertEquals(null, hit);
    }

    @Test
    public void hitIsAlwaysLowest(){
        Sphere s = new Sphere();
        Intersect i1 = new Intersect(5, s);
        Intersect i2 = new Intersect(7, s);
        Intersect i3 = new Intersect(-3, s);
        Intersect i4 = new Intersect(2, s);

        Intersections intersections = new Intersections(i1, i2, i3, i4);
        Intersect hit = intersections.hit();
        Assert.assertEquals(i4, hit);

    }
}