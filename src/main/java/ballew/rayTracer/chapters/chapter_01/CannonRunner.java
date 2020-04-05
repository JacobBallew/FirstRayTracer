package ballew.rayTracer.chapters.chapter_01;

import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Tuple;
import ballew.rayTracer.domain.Vector;

public class CannonRunner {

    public static final int ORIGIN = 0;


    public static void main(String[] args) throws InterruptedException {


        //
        Projectile p1 = new Projectile(
                new Point(0, 1, 0),
                Vector.normalizeVector(new Vector(1, 1, 0)));

        Env env1 = new Env(
                new Vector(0, -0.1, 0),
                new Vector(-0.01, 0, 0));

        // Run until we hit the ground, the ORIGIN
        while (p1.getPosition().getY() > ORIGIN) {

            p1.printMe();
            p1 = tick(env1, p1);

            if (p1.getPosition().getY() < ORIGIN) {
                System.out.println("Projectile has hit the ground!!!");
                System.out.println("Final Y: " + p1.getPosition().getY());
            }
            //Thread.sleep(LIBUltra.HALF_SECOND / 6);
        }

    }

    public static Projectile tick(Env env, Projectile p1) {
        Point newPosition = Point.toPoint(Tuple.add(p1.getPosition(), p1.getVelocity()));
        Vector newVelocity = Vector.toVector(Tuple.add(p1.getVelocity(), env.getGravity(), env.getWind()));
        return new Projectile(newPosition, newVelocity);
    }
}
