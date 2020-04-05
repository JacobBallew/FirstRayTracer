package ballew.testGround;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Color;
import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.save.SaveUtil;

public class SaveTester {

    public static void main(String[] args) {

        // Path to save
        String path = "C:\\Users\\jball\\Desktop\\test.ppm";

        // Create Canvas
        Canvas canvas = new Canvas(800, 600);

        // Create a random color
        Color red = Canvas.deScalePixel(new Color(255,179,221));

        // Set whole canvas to this color
        canvas.setSolidColor(red);

        // Create PPM Canvas
        CanvasPPM canvasPPM = new CanvasPPM(canvas);

        // Save
        canvasPPM.savePPM(path);




    }
}
