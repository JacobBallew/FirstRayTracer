package ballew.rayTracer.chapters.dataStructures;

import ballew.rayTracer.primatives.Sphere;
import ballew.rayTracer.utils.LIBUltra;
import org.junit.Assert;
import org.junit.Test;

public class IntersectTest {

    @Test
    public void hasTandObject(){
        Sphere s = new Sphere();
        Intersect i = new Intersect(3.5, s);

        Assert.assertEquals(3.5, i.tValue(), LIBUltra.EQUALITY_EPSILON);
        Assert.assertEquals(LIBUltra.SHAPE_TYPES.SPHERE, i.getPrimitive().getShapeType());
    }

}