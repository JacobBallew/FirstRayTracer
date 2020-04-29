package ballew.rayTracer.domain;

import ballew.rayTracer.dataStructures.Intersect;
import ballew.rayTracer.dataStructures.Intersections;
import ballew.rayTracer.primatives.Sphere;
import ballew.rayTracer.utils.LIBUltra;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void regressionTest(){
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();

        Intersections xs = new Intersections(Ray.intersect(s,r));

        Assert.assertEquals(2, xs.getCount());
        Assert.assertEquals(LIBUltra.SHAPE_TYPES.SPHERE, xs.get(0).getShapeType());
        Assert.assertEquals(LIBUltra.SHAPE_TYPES.SPHERE, xs.get(1).getShapeType());
    }
}