package ballew.rayTracer.primatives;

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


}