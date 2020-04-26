package ballew.rayTracer.chapters.dataStructures;

import ballew.rayTracer.primatives.Sphere;
import org.junit.Test;

public class IntersectionsTest {

    Intersections intersections = new Intersections();

    @Test
    public void multiIntersects(){
        Sphere s = new Sphere();

        Intersect i1 = new Intersect(1, s);
        Intersect i2 = new Intersect(2, s);

        intersections.add(i1, i2);
    }

}