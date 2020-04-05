package ballew.testGround;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Color;

public class CanvasTester {



    public static void main(String[] args) {

        Canvas canvas = new Canvas(10,20);
        Color red = new Color(1,0,0);

        System.out.println(Canvas.pixelAt(canvas,2,3));
        Canvas.writePixel(canvas,2,3,red);
        System.out.println(Canvas.pixelAt(canvas,2,3));

    }
}
