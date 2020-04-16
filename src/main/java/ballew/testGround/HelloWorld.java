package ballew.testGround;

import ballew.rayTracer.domain.Color;
import ballew.rayTracer.domain.Tuple;
import ballew.rayTracer.utils.LIBUltra;


public class HelloWorld {
    public static void main(String[] args) {

        double a = Math.toRadians(90);
        System.out.println(a);
        double aa = Math.cos(Math.PI/2);
        System.out.println(LIBUltra.round3places(aa));

    }

    public static double toRadians(double degrees) {
        return (degrees / 180) * Math.PI;
    }
}
