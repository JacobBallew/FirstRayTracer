package ballew.rayTracer.chapters.chapter_04;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Color;
import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.ppm.CanvasPPM;

import java.util.Arrays;

public class DrawingAClock {

    public static void main(String[] args) {

        // Path to save image
        String path = "C:\\Users\\jball\\Desktop\\test.ppm";

        // Dimensions of canvas
        int width = 400;
        int height = 400;

        // Create Canvas
        Canvas canvas = new Canvas(width, height);

        // Point with Initial position -> the origin
        Point p = new Point(0, 0, 0);

        //Write initial point
        canvas.writePixelBold(canvas.fromCartesian_Y(p.getY()), canvas.fromCartesian_X(p.getX()), new Color(1, 1, 1));

        // Create a new point by translating from origin to hour 12
        Matrix translation = Matrix.translation(0, 100, 0);
        Point twelve = Point.toPoint(Matrix.multiplyByTuple(translation, p));

        // Calculate each hour by rotating point 12 by half quarters
        for(int i = 0; i < 12; i++){
            //Matrix rotation = Matrix.rotationZ(((Math.PI / 6) * i));
            Matrix rotation = Matrix.rotationZ_deg(30 * i);
            Point hour = Point.toPoint(Matrix.multiplyByTuple(rotation, twelve));
            canvas.writePixelBold(canvas.fromCartesian_Y(hour.getY()), canvas.fromCartesian_X(hour.getX()), new Color(0, 1, 0));
        }

        // Save canvas
        CanvasPPM canvasPPM = new CanvasPPM(canvas);
        canvasPPM.savePPM(path);
    }

}
