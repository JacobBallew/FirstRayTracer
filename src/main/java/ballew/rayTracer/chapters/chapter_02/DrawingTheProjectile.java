package ballew.rayTracer.chapters.chapter_02;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.chapters.chapter_01.Env;
import ballew.rayTracer.chapters.chapter_01.Projectile;
import ballew.rayTracer.domain.Color;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Tuple;
import ballew.rayTracer.domain.Vector;
import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.utils.LIBUltra;

public class DrawingTheProjectile {
    public static final int ORIGIN = 0;

    public static void main(String[] args) {

        // Path to save
        String path = "C:\\Users\\jball\\Desktop\\test.ppm";

        // Dimensions
        int width = 1200;
        int height = 720;

        // Create Canvas
        Canvas canvas = new Canvas(width, height);

        // Create Projectile
        Point startPoint = new Point(10, 1, 0);
        Vector startVelocity = Vector.normalizeVector(Vector.toVector(Vector.multiply(new Vector(10, 21.8, 0), 11.25)));
        Projectile projectile = new Projectile(startPoint, startVelocity);

        // Create environment factors
        Vector gravity = new Vector(0, -.001, 0);
        Vector wind = new Vector(0, 0, 0);
        Env environment = new Env(gravity, wind);

        // Run until we hit the ground, the ORIGIN
        double peak = 0;
        while (projectile.getPosition().getY() > ORIGIN) {

            //projectile.printMe();
            projectile = tick(environment, projectile);

            if (projectile.getPosition().getY() < ORIGIN) {
                System.out.println("Projectile has hit the ground!!!");
                System.out.println("Projectile peaked at " + peak);
                System.out.println("Final Y: " + projectile.getPosition().getY());
            }
            // Track peak position
            if (projectile.getPosition().getY() > peak) {
                peak = projectile.getPosition().getY();
            }

            // Plot on Canvas
            canvas.writePixel(
                    (height - (int) projectile.getPosition().getY()),
                    (int) projectile.getPosition().getX(), new Color(1, 0, 0));
        }

        // Add thickness to the line
        padLine(canvas);

        // Save canvas
        CanvasPPM canvasPPM = new CanvasPPM(canvas);
        canvasPPM.savePPM(path);

    }

    public static Projectile tick(Env env, Projectile p1) {
        //Vector newWind = new Vector(LIBUltra.randomDouble(-.01, 1),0,0);
        Vector newWind = new Vector(0,0,0);

        Point newPosition = Point.toPoint(Tuple.add(p1.getPosition(), p1.getVelocity()));
        Vector newVelocity = Vector.toVector(Tuple.add(p1.getVelocity(), env.getGravity(), newWind));
        return new Projectile(newPosition, newVelocity);
    }

    // Add thickness to the line for ease of viewing
    public static void padLine(Canvas c) {
        for (int i = 0; i < c.getHeight(); i++) {
            for (int j = 0; j < c.getWidth(); j++) {
                if (c.pixelAt(i, j).equals(new Color(1, 0, 0))) {
                    c.writePixel(i, j - 1, Canvas.deScalePixel(new Color(255,0,0)));
                    c.writePixel(i, j - 2, Canvas.deScalePixel(new Color(255,0,0)));
                    c.writePixel(i, j - 3, Canvas.deScalePixel(new Color(255,0,0)));
                }
            }
        }
    }
}
