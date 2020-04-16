package ballew.rayTracer.chapters.chapter_04;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Color;
import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.ppm.CanvasPPM;

import java.util.Arrays;

public class DrawingAClock {

    public static void main(String[] args) {

        // Path to save
        String path = "C:\\Users\\jball\\Desktop\\test.ppm";

        // Dimensions
        int width = 1200;
        int height = 720;

        // Create Canvas
        Canvas canvas = new Canvas(width, height);

        // Point with Initial position. Origin
        Point p = new Point(canvas.getXMid(), canvas.getYMid(), 0);



        //Write Pixel
        System.out.println(p);
        canvas.writePixelBold(
                (height - (int) p.getY()),
                (int) p.getX(),
                new Color(0, 0, 1));

        // Calculate positions
        Matrix rotation = Matrix.rotationZ_deg(-5);
        Matrix translation = Matrix.translation(0,10,0);
        Matrix finalTransform = Matrix.chainTransformations(Arrays.asList(rotation,translation));

        Point p2 = Point.toPoint(Matrix.multiplyByTuple(rotation, p));

        //Write Pixel
        System.out.println(p2);
        canvas.writePixelBold(
                (height - (int) p2.getY()),
                (int) p2.getX(),
                new Color(1, 0, 0));


        // Save canvas
        CanvasPPM canvasPPM = new CanvasPPM(canvas);
        canvasPPM.savePPM(path);
    }

}
