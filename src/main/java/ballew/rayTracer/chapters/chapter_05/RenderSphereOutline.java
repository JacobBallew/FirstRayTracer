package ballew.rayTracer.chapters.chapter_05;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.dataStructures.Intersections;
import ballew.rayTracer.domain.*;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.primitive.Sphere;
import ballew.rayTracer.utils.LIBUltra;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// See page 73
public class RenderSphereOutline {

    static int canvasSize = 200;

    public static void main(String[] args) {

        // Setup
        String path = "c:/Users/jball/Desktop/sphere_silhouette.ppm";
        Canvas canvas = new Canvas(canvasSize);

        Point rayOrigin = new Point(0, 0, -5);
        double wall_z = 10;
        double wall_size = 7;
        double pixel_size = wall_size / canvasSize;
        double half = wall_size / 2;

        Sphere sphere = new Sphere();
        //sphere.setTransform(Matrix.scaling(1,0.5,1));


        double worldY, worldX;
        for (int y = 0; y < canvasSize; y++) {
            worldY = half - pixel_size * y;
            for (int x = 0; x < canvasSize; x++) {
                worldX = -half + pixel_size * x;

                Point position = new Point(worldX, worldY, wall_z);

                Ray r = new Ray(rayOrigin, Vector.normalizeVector(Vector.toVector(Tuple.subtract(position, rayOrigin))));
                Intersections xs = new Intersections(r.intersect(sphere));

                if (xs.hit() != null) {
                    canvas.writePixel(x, y, LIBUltra.randomColor());
                }
            }
        }

        // Save Canvas
        CanvasPPM saveFile = new CanvasPPM(canvas);
        saveFile.savePPM(path);
    }


}
