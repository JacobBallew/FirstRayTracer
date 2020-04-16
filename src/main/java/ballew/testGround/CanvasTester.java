package ballew.testGround;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.utils.LIBUltra;

public class CanvasTester {



    public static void main(String[] args) {

        // Path to save
        String path = "C:\\Users\\jball\\Desktop\\test.ppm";

        // Dimensions
        int width = 400;
        int height = 400;

        // Create Canvas
        Canvas canvas = new Canvas(width, height);

        // Point with Initial position. Origin
        Point p = new Point(0 , -10, 0);

        canvas.writePixelBold(canvas.fromCartesian_Y(p.getY()), canvas.fromCartesian_X(p.getX()), LIBUltra.RED);
        System.out.println(canvas.fromCartesian_Y(p.getY()) + " - " + canvas.fromCartesian_X(p.getX()));
        CanvasPPM canvasPPM = new CanvasPPM(canvas);
        canvasPPM.savePPM(path);

    }
}
